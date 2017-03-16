package com.garyluoex.project;

import com.garyluoex.project.data.ResultData;
import com.garyluoex.project.processor.DataProcessingThread;
import com.garyluoex.project.gui.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static com.garyluoex.project.config.Configuration.FRAME_HEIGHT;
import static com.garyluoex.project.config.Configuration.FRAME_WIDTH;

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

        CompositeLeafBufferedImage compositeLeafBufferedImage =
                new CompositeLeafBufferedImage(
                        "src/main/resources/greenleaf.png",
                        "src/main/resources/redleaf.png"
                );


        LeafPanel leafPanel = new LeafPanel(compositeLeafBufferedImage);

        ClickUpdateOpacityListener clickUpdateOpacityListener = new ClickUpdateOpacityListener(compositeLeafBufferedImage, leafPanel);
        CalibrationListener calibrationListener = new CalibrationListener();

        leafPanel.getLabel().addMouseListener(clickUpdateOpacityListener);
        ControlPanel controlPanel = new ControlPanel(calibrationListener);

        myGUI.add(leafPanel, BorderLayout.WEST);
        myGUI.add(controlPanel, BorderLayout.EAST);

        myGUI.setVisible(true);

        System.out.println("Entering main thread loop");

        // Loop to update GUI given the current state of data and result
        while (true) {
            leafPanel.getLabel().setIcon(new ImageIcon(compositeLeafBufferedImage.getNewOpacityImage((float) ResultData.getResult())));
        }
    }
}
