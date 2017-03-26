package com.garyluoex.project;

import com.garyluoex.project.data.ResultData;
import com.garyluoex.project.processor.DataProcessingThread;
import com.garyluoex.project.gui.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static com.garyluoex.project.config.Configuration.*;

/**
 * Created by kaluo on 3/12/17.
 */
public class Application {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Start collecting sensor data from arduino usb connection
        DataProcessingThread dataProcessingThread = new DataProcessingThread();
        dataProcessingThread.start();

        // Initialize GUI to show
        MainFrame myGUI = new MainFrame();
        myGUI.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        CompositeLeafBufferedImage compositeLeafBufferedImage = new CompositeLeafBufferedImage(DOT_GREEN_URL, DOT_RED_URL);

        LeafPanel leafPanel = new LeafPanel(compositeLeafBufferedImage);

        ClickUpdateOpacityListener clickUpdateOpacityListener = new ClickUpdateOpacityListener(compositeLeafBufferedImage, leafPanel);
        CalibrationListener calibrationListener = new CalibrationListener();

        leafPanel.getLabel().addMouseListener(clickUpdateOpacityListener);
        ControlPanel controlPanel = new ControlPanel(calibrationListener);

        myGUI.add(leafPanel, BorderLayout.CENTER);
        myGUI.add(controlPanel, BorderLayout.WEST);

        myGUI.setVisible(true);

        leafPanel.getLabel().setLocation(-8, 1);

        System.out.println("Entering main thread loop");

        // Loop to update GUI given the current state of data and result
        while (true) {
            double normalizedDistance = ResultData.getResult();
            int x_diff = (int) (CIRCLE_CENTER_X + ResultData.getResult_x() * POSITION_FACTOR);
            int y_diff = (int) (CIRCLE_CENTER_Y - ResultData.getResult_y() * POSITION_FACTOR);

            leafPanel.getLabel().setLocation(x_diff, y_diff);

            leafPanel.getLabel().setIcon(new ImageIcon(compositeLeafBufferedImage.getNewOpacityImage((float) normalizedDistance)));
        }
    }
}
