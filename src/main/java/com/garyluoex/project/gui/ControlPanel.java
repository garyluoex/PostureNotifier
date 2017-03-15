package com.garyluoex.project.gui;

import static com.garyluoex.project.config.Configuration.*;
import javax.imageio.ImageIO;
import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by kaluo on 3/14/17.
 */
public class ControlPanel extends JPanel {



    public ControlPanel(MouseAdapter mouseAdapter) throws IOException {
        super();

        JButton calibration = new JButton();
        calibration.setIcon(new ImageIcon(ImageIO.read(new File(CALIBRATE_BUTTON_URL))));
        calibration.setAlignmentX(Component.CENTER_ALIGNMENT);
        calibration.addMouseListener(mouseAdapter);

        JButton history = new JButton();
        history.setIcon(new ImageIcon(ImageIO.read(new File(HISTORY_BUTTON_URL))));
        history .setAlignmentX(Component.CENTER_ALIGNMENT);
        history.addMouseListener(mouseAdapter);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(calibration);
        this.add(history);
    }
}
