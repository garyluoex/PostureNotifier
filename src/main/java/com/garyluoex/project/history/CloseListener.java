package com.garyluoex.project.history;

import com.garyluoex.project.gui.HistoryListener;
import com.garyluoex.project.gui.ImageUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import static com.garyluoex.project.config.Configuration.BUTTON_HEIGHT;
import static com.garyluoex.project.config.Configuration.BUTTON_WIDTH;
import static com.garyluoex.project.config.Configuration.HISTORY_BUTTON_GREY_URL;

/**
 * Created by kaluo on 3/27/17.
 */
public class CloseListener extends WindowAdapter {

    private final JButton historyButton;

    public CloseListener(JButton historyButton) {
        this.historyButton = historyButton;
    }

    @Override
    public void windowClosing(WindowEvent e)
    {
        try {
            historyButton.setIcon(new ImageIcon(ImageUtils.scaleImage(ImageIO.read(new File(HISTORY_BUTTON_GREY_URL)), BUTTON_WIDTH, BUTTON_HEIGHT)));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
