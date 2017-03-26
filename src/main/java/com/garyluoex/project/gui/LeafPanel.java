package com.garyluoex.project.gui;

import static com.garyluoex.project.config.Configuration.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
        this.setSize(DOT_WIDTH, DOT_HEIGHT);
        this.setLayout(new BorderLayout());
        this.add(leafLabel);
    }

    public JLabel getLabel() {
        return leafLabel;
    }

    public void updateLabelImage(BufferedImage newImage) {
        leafLabel.setIcon(new ImageIcon(newImage));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // paint the background image and scale it to fill the entire space
        try {
            BufferedImage sourceImage = ImageIO.read(new File(BACKGROUND_CIRCLE_URL));
            BufferedImage scaledImage = new BufferedImage(CIRCLE_WIDTH, CIRCLE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
            scaledImage.getGraphics().drawImage(sourceImage.getScaledInstance(CIRCLE_WIDTH, CIRCLE_HEIGHT, Image.SCALE_SMOOTH), 0, 0, null);
            g.drawImage(scaledImage, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
