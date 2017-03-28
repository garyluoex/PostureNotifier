package com.garyluoex.project.history;

import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.IOException;

import static com.garyluoex.project.config.Configuration.*;

/**
 * Created by kaluo on 3/12/17.
 */
public class HistoryFrame extends JFrame {

    public HistoryFrame() throws IOException {
        super("Posture History");
        setLayout(new BorderLayout());
        setAlwaysOnTop(true);
        setResizable(false);
        setSize(HISTORY_FRAME_WIDTH, HISTORY_FRAME_HEIGHT+20);
        getContentPane().setSize(HISTORY_FRAME_WIDTH, HISTORY_FRAME_HEIGHT);
        HistoryPanel historyPanel = new HistoryPanel();
        add(new HistoryPanel(), BorderLayout.CENTER);
        setLocation(HISTORY_FRAME_START_X,HISTORY_FRAME_START_Y);
        historyPanel.setVisible(true);

    }
}
