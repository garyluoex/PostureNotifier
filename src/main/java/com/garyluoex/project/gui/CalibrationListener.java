package com.garyluoex.project.gui;

import com.garyluoex.project.data.ResultData;
import com.garyluoex.project.processor.ResultProcessor;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by kaluo on 3/14/17.
 */
public class CalibrationListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent event) {
        ResultProcessor.calibration = ! ResultProcessor.calibration;
    }
}
