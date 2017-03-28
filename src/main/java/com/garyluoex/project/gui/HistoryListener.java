package com.garyluoex.project.gui;

import com.garyluoex.project.processor.ResultProcessor;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by kaluo on 3/14/17.
 */
public class HistoryListener extends MouseAdapter {

    private final ControlPanel controlPanel;
    private final IndicatorPanel indicatorPanel;

    public HistoryListener(ControlPanel controlPanel, IndicatorPanel indicatorPanel) {
        this.controlPanel = controlPanel;
        this.indicatorPanel = indicatorPanel;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if (controlPanel.isVisible()) {
            System.out.println("show indicator");
            controlPanel.setVisible(false);
            indicatorPanel.setVisible(true);
        } else {
            System.out.println("show controller");
            indicatorPanel.setVisible(false);
            controlPanel.setVisible(true);
        }
    }
}
