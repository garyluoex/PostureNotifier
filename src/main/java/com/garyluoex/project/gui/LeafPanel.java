package com.garyluoex.project.gui;

import static com.garyluoex.project.config.Configuration.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by kaluo on 3/14/17.
 */
public class LeafPanel extends JPanel {

    private final BufferedImage leafImage;
    private final JLabel leafLabel;

    public LeafPanel(BufferedImage leafImage) {
        super();

        // Label config
        this.leafImage = leafImage;
        this.leafLabel = new JLabel(new ImageIcon(this.leafImage));

        // Panel config
        this.setSize(LEAF_WIDTH, LEAF_HEIGHT);
        this.setLayout(new BorderLayout());
        this.add(leafLabel);
    }

    public JLabel getLabel() {
        return leafLabel;
    }

    public void updateLabelImage(BufferedImage newImage) {
        leafLabel.setIcon(new ImageIcon(newImage));
    }
}
