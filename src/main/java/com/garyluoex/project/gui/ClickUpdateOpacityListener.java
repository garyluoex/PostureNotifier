package com.garyluoex.project.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by kaluo on 3/14/17.
 */
public class ClickUpdateOpacityListener extends MouseAdapter {

    private final CompositeLeafBufferedImage leafImage;
    private final LeafPanel leafPanel;
    private float opacity = 0.0f;

    public ClickUpdateOpacityListener(CompositeLeafBufferedImage leafImage, LeafPanel leafPanel) {
        this.leafImage = leafImage;
        this.leafPanel = leafPanel;
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        opacity += 0.1f;
        if (opacity >= 1.0f) {
            opacity = 0.0f;
        }

        try {
            leafPanel.getLabel().setIcon(new ImageIcon(leafImage.getNewOpacityImage(opacity)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
