package com.garyluoex.project.gui;

import static com.garyluoex.project.config.Configuration.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kaluo on 3/12/17.
 */
public class MainFrame extends JFrame {
    private JLabel item1;

    public MainFrame() {
        super("Posture Detector");
        setAlwaysOnTop(true);
//        setResizable(false);
        setSize(FRAME_WIDTH, FRAME_HEIGHT+20);
        getContentPane().setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }
}
