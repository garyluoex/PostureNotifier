package com.garyluoex.project;

import com.garyluoex.project.data.DataResult;
import com.garyluoex.project.data.DataThread;
import com.garyluoex.project.gui.*;
import com.garyluoex.project.processor.TestDataProcessor;

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
        DataResult dataResult = new DataResult();
        TestDataProcessor testDataProcessor = new TestDataProcessor(dataResult);
        DataThread dataThread = new DataThread(testDataProcessor);
        dataThread.start();

        // Initialize GUI to show
        System.out.println("Entering GUI section");
        MainFrame myGUI = new MainFrame();
        myGUI.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        CompositeLeafBufferedImage compositeLeafBufferedImage =
                new CompositeLeafBufferedImage(
                        "src/main/resources/greenleaf.png",
                        "src/main/resources/redleaf.png"
                );


        LeafPanel leafPanel = new LeafPanel(compositeLeafBufferedImage);

        ClickUpdateOpacityListener clickUpdateOpacityListener = new ClickUpdateOpacityListener(compositeLeafBufferedImage, leafPanel);

        leafPanel.getLabel().addMouseListener(clickUpdateOpacityListener);

        ControlPanel controlPanel = new ControlPanel(clickUpdateOpacityListener);

        myGUI.add(leafPanel, BorderLayout.WEST);
        myGUI.add(controlPanel, BorderLayout.EAST);

        myGUI.setVisible(true);

        // Loop to update GUI given the current state of data and result
        while (true) {
        }
    }
}
