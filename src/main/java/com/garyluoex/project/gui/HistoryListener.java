package com.garyluoex.project.gui;

import com.garyluoex.project.history.CloseListener;
import com.garyluoex.project.history.HistoryFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import static com.garyluoex.project.config.Configuration.*;
import static com.garyluoex.project.config.Configuration.BUTTON_HEIGHT;
import static com.garyluoex.project.config.Configuration.BUTTON_WIDTH;

/**
 * Created by kaluo on 3/14/17.
 */
public class HistoryListener extends MouseAdapter {

    private final HistoryFrame historyFrame;
    private final JButton historyButton;


    public HistoryListener(JButton historyButton) throws IOException {
        this.historyButton = historyButton;
        historyFrame = new HistoryFrame();
        historyFrame.addWindowListener(new CloseListener(historyButton));
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if (!historyFrame.isVisible()) {
            try {
                historyFrame.setVisible(true);
                ((JButton) event.getComponent()).setIcon(new ImageIcon(ImageUtils.scaleImage(ImageIO.read(new File(HISOTRY_BUTTON_GREEN_URL)), BUTTON_WIDTH, BUTTON_HEIGHT)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                historyFrame.setVisible(false);
                ((JButton) event.getComponent()).setIcon(new ImageIcon(ImageUtils.scaleImage(ImageIO.read(new File(HISTORY_BUTTON_GREY_URL)), BUTTON_WIDTH, BUTTON_HEIGHT)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
