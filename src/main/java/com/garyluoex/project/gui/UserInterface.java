package com.garyluoex.project.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kaluo on 3/12/17.
 */
public class UserInterface extends JFrame {
    private JLabel item1;

    public UserInterface() {
        super("Posture Detector");
        setLayout(new FlowLayout());

        item1 = new JLabel("this is a sentence");
        item1.setToolTipText("hi, im sentence");
        add(item1);
    }
}
