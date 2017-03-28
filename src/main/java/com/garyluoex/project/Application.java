package com.garyluoex.project;

import com.garyluoex.project.data.ResultData;
import com.garyluoex.project.processor.DataProcessingThread;
import com.garyluoex.project.gui.*;

import javax.swing.*;
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
        CompositeLeafBufferedImage compositeDotImage = new CompositeLeafBufferedImage(DOT_GREEN_URL, DOT_RED_URL);

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

        // Loop to update GUI given the current state of data and result
        while (true) {
            double normalizedDistance = ResultData.getResult();
            int x_diff = (int) (DOT_CENTER_X - ResultData.getResult_x() * POSITION_FACTOR);
            int y_diff = (int) (DOT_CENTER_Y - ResultData.getResult_y() * POSITION_FACTOR);

            indicatorPanel.getLabel().setLocation(x_diff, y_diff);

            indicatorPanel.getLabel().setIcon(new ImageIcon(compositeDotImage.getNewOpacityImage((float) normalizedDistance)));
        }
    }
}
