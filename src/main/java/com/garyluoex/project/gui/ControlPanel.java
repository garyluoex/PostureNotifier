package com.garyluoex.project.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;

import static com.garyluoex.project.config.Configuration.*;

/**
 * Created by kaluo on 3/14/17.
 */
public class ControlPanel extends JPanel {

    public ControlPanel(MouseAdapter mouseAdapter) throws IOException {
        super();

        JButton calibration = new JButton();
        calibration.setIcon(new ImageIcon(ImageUtils.scaleImage(ImageIO.read(new File(CALIBRATE_BUTTON_URL)), BUTTON_WIDTH, BUTTON_HEIGHT)));
        calibration.setAlignmentX(Component.CENTER_ALIGNMENT);
        calibration.addMouseListener(mouseAdapter);
        calibration.setBounds(FRAME_WIDTH/2-BUTTON_WIDTH/2, FRAME_HEIGHT/4, BUTTON_WIDTH, BUTTON_HEIGHT);
        calibration.setBorderPainted(false);

        JButton history = new JButton();
        history.setIcon(new ImageIcon(ImageUtils.scaleImage(ImageIO.read(new File(HISTORY_BUTTON_URL)), BUTTON_WIDTH, BUTTON_HEIGHT)));
        history.setAlignmentX(Component.CENTER_ALIGNMENT);
        history.addMouseListener(mouseAdapter);
        history.setBounds(FRAME_WIDTH/2-BUTTON_WIDTH/2, 4*FRAME_HEIGHT/5, BUTTON_WIDTH, BUTTON_HEIGHT);
        history.setBorderPainted(false);

        setBackground(Color.WHITE);

        setLayout(null);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(false);
        add(calibration);
        add(history);

    }
}
