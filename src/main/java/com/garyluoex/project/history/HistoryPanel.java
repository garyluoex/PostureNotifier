package com.garyluoex.project.history;

import com.garyluoex.project.gui.ImageUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.garyluoex.project.config.Configuration.*;

/**
 * Created by kaluo on 3/14/17.
 */
public class HistoryPanel extends JPanel {

    private final JLabel chartLabel;

    public HistoryPanel() throws IOException {
        super();

        // Label config
        this.chartLabel = new JLabel(new ImageIcon(ImageUtils.scaleImage(ImageIO.read(new File(HISTORY_HOUR_URL)), HISTORY_FRAME_WIDTH, HISTORY_FRAME_HEIGHT)));

        // Panel config
        setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        this.add(chartLabel, BorderLayout.CENTER);
        chartLabel.setVisible(true);
        addMouseListener(new SwitchGranularityListener(this));
    }

    public JLabel getLabel() {
        return chartLabel;
    }

    public void updateLabelImage(BufferedImage newImage) {
        chartLabel.setIcon(new ImageIcon(newImage));
    }
}
