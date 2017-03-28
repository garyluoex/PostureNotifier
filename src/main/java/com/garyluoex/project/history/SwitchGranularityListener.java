package com.garyluoex.project.history;

import static com.garyluoex.project.config.Configuration.*;

import com.garyluoex.project.gui.ControlPanel;
import com.garyluoex.project.gui.ImageUtils;
import com.garyluoex.project.gui.IndicatorPanel;

import javax.imageio.ImageIO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import static com.garyluoex.project.config.Configuration.HISTORY_FRAME_HEIGHT;
import static com.garyluoex.project.config.Configuration.HISTORY_FRAME_WIDTH;
import static com.garyluoex.project.config.Configuration.HISTORY_HOUR_URL;

/**
 * Created by kaluo on 3/14/17.
 */
public class SwitchGranularityListener extends MouseAdapter {

    private final HistoryPanel historyPanel;
    private int current;

    public SwitchGranularityListener(HistoryPanel historyPanel) {
        this.historyPanel = historyPanel;
        this.current = 1;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        System.out.println("Switching history granularity");
        if (current == 0) {
            try {
                historyPanel.updateLabelImage(ImageUtils.scaleImage(ImageIO.read(new File(HISTORY_HOUR_URL)), HISTORY_FRAME_WIDTH, HISTORY_FRAME_HEIGHT));
            } catch (IOException e) {
                e.printStackTrace();
            }
            current = 1;
            return;
        }
        if (current == 1) {
            try {
                historyPanel.updateLabelImage(ImageUtils.scaleImage(ImageIO.read(new File(HISTORY_DAY_URL)), HISTORY_FRAME_WIDTH, HISTORY_FRAME_HEIGHT));
            } catch (IOException e) {
                e.printStackTrace();
            }
            current = 2;
            return;
        }
        if (current == 2) {
            try {
                historyPanel.updateLabelImage(ImageUtils.scaleImage(ImageIO.read(new File(HISTORY_WEEK_URL)), HISTORY_FRAME_WIDTH, HISTORY_FRAME_HEIGHT));
            } catch (IOException e) {
                e.printStackTrace();
            }
            current = 3;
            return;
        }
        if (current == 3) {
            try {
                historyPanel.updateLabelImage(ImageUtils.scaleImage(ImageIO.read(new File(HISTORY_MONTH_URL)), HISTORY_FRAME_WIDTH, HISTORY_FRAME_HEIGHT));
            } catch (IOException e) {
                e.printStackTrace();
            }
            current = 0;
            return;
        }
    }
}
