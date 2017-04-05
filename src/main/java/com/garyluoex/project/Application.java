package com.garyluoex.project;

import com.garyluoex.project.data.ResultData;
import com.garyluoex.project.processor.DataProcessingThread;
import com.garyluoex.project.gui.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

import static com.garyluoex.project.config.Configuration.*;

/**
 * Created by kaluo on 3/12/17.
 */
public class Application {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Start Data Thread
        DataProcessingThread dataProcessingThread = new DataProcessingThread();
        dataProcessingThread.start();

        // Composite Images
        CompositeLeafBufferedImage compositeDotImage = new CompositeLeafBufferedImage(DOT_GREEN_URL, DOT_ORANGE_URL);

        // Indicator Panel Setup
        IndicatorPanel indicatorPanel = new IndicatorPanel(compositeDotImage);

        CalibrationListener calibrationListener = new CalibrationListener();

        // Control Panel Setup
        ControlPanel controlPanel = new ControlPanel(calibrationListener);

        MainFrame myGUI = new MainFrame();

        SwitchPanelListener switchPanelListener = new SwitchPanelListener(controlPanel, indicatorPanel);

        indicatorPanel.addMouseListener(switchPanelListener);
        controlPanel.addMouseListener(switchPanelListener);

        indicatorPanel.setVisible(true);

        myGUI.add(indicatorPanel);
        myGUI.add(controlPanel);

        myGUI.setVisible(true);

        System.out.println("Entering main thread loop");

        long start = System.nanoTime();
        long duration = System.nanoTime();
        long flash = System.nanoTime();
        boolean visible = true;

        // Loop to update GUI given the current state of data and result
        while (true) {
            double normalizedDistance = ResultData.getResult();
            int x_diff = (int) (DOT_CENTER_X - ResultData.getResult_x() * POSITION_FACTOR);
            int y_diff = (int) (DOT_CENTER_Y - ResultData.getResult_y() * POSITION_FACTOR);

            double radius = Math.sqrt(x_diff ^ 2 + y_diff ^ 2);

            if (radius < RED_DOT_RADIUS_THRESHOLD) {
                start = System.nanoTime();
            }

            indicatorPanel.getLabel().setLocation(
                    (int) (Math.abs(x_diff) > FRAME_WIDTH ? Math.signum(x_diff) * FRAME_WIDTH : x_diff),
                    (int) (Math.abs(y_diff) > FRAME_HEIGHT ? Math.signum(y_diff) * FRAME_HEIGHT : y_diff)
            );

            if (ResultData.getSeated()) {
                double elapsedTime = (System.nanoTime() - start) / 1000000000.0;

                if (elapsedTime > RED_DOT_TIME) {
                    indicatorPanel.getLabel().setIcon(new ImageIcon(ImageUtils.scaleImage(ImageIO.read(new File(DOT_RED_URL)), DOT_WIDTH, DOT_HEIGHT)));
                    double lastTime = (System.nanoTime() - duration) / 1000000000.0;
                    double flashTime = (System.nanoTime() - flash) / 1000000000.0;

                    if (flashTime > FLASH_TIME) {
                        indicatorPanel.getLabel().setVisible(visible);
                        flash = System.nanoTime();
                        visible = !visible;
                    }

                    if (lastTime > DURATION_TIME) {
                        try {
                            //System.out.println("Trying to sent data to arduino: " + "echo 1 > " + USB_DEVICE_URL);
                            Runtime.getRuntime().exec(new String[]{"sh", "-c", "echo 5 > " + USB_DEVICE_URL});
                        } catch (IOException e) {
                            throw new RuntimeException("Can not send vibration signal to arduino", e);
                        }
                        duration = System.nanoTime();
                    }
                } else {
                    indicatorPanel.getLabel().setIcon(new ImageIcon(compositeDotImage.getNewOpacityImage((float) normalizedDistance)));
                    indicatorPanel.getLabel().setVisible(true);
                }
            } else {
                indicatorPanel.getLabel().setVisible(false);
            }
        }
    }
}
