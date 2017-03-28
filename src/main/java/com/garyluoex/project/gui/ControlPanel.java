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

    private final MouseAdapter historyAdapter;

    public ControlPanel(MouseAdapter calibrationAdapter) throws IOException {
        super();

        JButton calibration = new JButton();
        calibration.setIcon(new ImageIcon(ImageUtils.scaleImage(ImageIO.read(new File(CALIBRATE_BUTTON_GREY_URL)), BUTTON_WIDTH, BUTTON_HEIGHT)));
        calibration.setAlignmentX(Component.CENTER_ALIGNMENT);
        calibration.addMouseListener(calibrationAdapter);
        calibration.setBounds(FRAME_WIDTH/2-BUTTON_WIDTH/2, (int)((FRAME_HEIGHT-BUTTON_HEIGHT)/BUTTON_GAP_FACTOR), BUTTON_WIDTH, BUTTON_HEIGHT);
        calibration.setBorderPainted(false);

        JButton history = new JButton();
        history.setIcon(new ImageIcon(ImageUtils.scaleImage(ImageIO.read(new File(HISTORY_BUTTON_GREY_URL)), BUTTON_WIDTH, BUTTON_HEIGHT)));
        history.setAlignmentX(Component.CENTER_ALIGNMENT);
        history.setBounds(FRAME_WIDTH/2-BUTTON_WIDTH/2, (int)(FRAME_HEIGHT-(FRAME_HEIGHT-BUTTON_HEIGHT)/BUTTON_GAP_FACTOR-BUTTON_HEIGHT), BUTTON_WIDTH, BUTTON_HEIGHT);
        history.setBorderPainted(false);

        this.historyAdapter = new HistoryListener(history);
        history.addMouseListener(historyAdapter);

        setBackground(Color.WHITE);

        setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        setLayout(null);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(false);
        add(calibration);
        add(history);

    }
}
