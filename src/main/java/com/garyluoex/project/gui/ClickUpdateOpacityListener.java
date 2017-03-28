package com.garyluoex.project.gui;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by kaluo on 3/14/17.
 */
public class ClickUpdateOpacityListener extends MouseAdapter {

    private final CompositeLeafBufferedImage leafImage;
    private final IndicatorPanel indicatorPanel;
    private float opacity = 0.0f;

    public ClickUpdateOpacityListener(CompositeLeafBufferedImage leafImage, IndicatorPanel indicatorPanel) {
        this.leafImage = leafImage;
        this.indicatorPanel = indicatorPanel;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        opacity += 0.1f;
        if (opacity >= 1.0f) {
            opacity = 0.0f;
        }

        try {
            indicatorPanel.getLabel().setIcon(new ImageIcon(leafImage.getNewOpacityImage(opacity)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
