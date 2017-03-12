package com.garyluoex.project;

import com.garyluoex.project.data.DataProcessor;
import com.garyluoex.project.data.DataThread;
import com.garyluoex.project.gui.UserInterface;

import java.io.IOException;

/**
 * Created by kaluo on 3/12/17.
 */
public class Application {

    public static void main(String[] args) throws IOException {

        // Start collecting sensor data from arduino usb connection
        DataThread dataThread = new DataThread("sensor data");
        dataThread.start();

        // Initialize GUI to show
        System.out.println("Entering GUI section");
        UserInterface myGUI = new UserInterface();
        myGUI.setVisible(true);

        // Loop to update GUI given the current state of data and result
        while(true) {
            System.out.println(DataProcessor.getResult());
        }
    }
}
