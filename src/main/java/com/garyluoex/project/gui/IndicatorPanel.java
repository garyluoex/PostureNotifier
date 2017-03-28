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
public class IndicatorPanel extends JPanel {

    private final BufferedImage dotImage;
    private final JLabel dotLabel;

    public IndicatorPanel(BufferedImage dotImage) {
        super();

        // Label config
        this.dotImage = dotImage;
        this.dotLabel = new JLabel(new ImageIcon(this.dotImage));

        // Panel config
        setBackground(Color.WHITE);
        this.setSize(DOT_WIDTH, DOT_HEIGHT);
        this.setLayout(new BorderLayout());
        this.add(dotLabel);
        setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
    }

    public JLabel getLabel() {
        return dotLabel;
    }

    public void updateLabelImage(BufferedImage newImage) {
        dotLabel.setIcon(new ImageIcon(newImage));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // paint the background image and scale it to fill the entire space
        try {
            BufferedImage scaledImage = ImageUtils.scaleImage(ImageIO.read(new File(BACKGROUND_CIRCLE_URL)), FRAME_WIDTH, FRAME_HEIGHT);
            g.drawImage(scaledImage, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
