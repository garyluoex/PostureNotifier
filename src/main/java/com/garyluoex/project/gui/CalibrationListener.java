package com.garyluoex.project.gui;

import com.garyluoex.project.data.ResultData;
import com.garyluoex.project.processor.ResultProcessor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import static com.garyluoex.project.config.Configuration.*;

/**
 * Created by kaluo on 3/14/17.
 */
public class CalibrationListener extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent event) {
        System.out.println("calibrated");
        ResultProcessor.calibration = ! ResultProcessor.calibration;
        if (ResultProcessor.calibration) {
            try {
                ((JButton) event.getComponent()).setIcon(new ImageIcon(ImageUtils.scaleImage(ImageIO.read(new File(CALIBRATE_BUTTON_GREEN_URL)), BUTTON_WIDTH, BUTTON_HEIGHT)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                ((JButton) event.getComponent()).setIcon(new ImageIcon(ImageUtils.scaleImage(ImageIO.read(new File(CALIBRATE_BUTTON_GREY_URL)), BUTTON_WIDTH, BUTTON_HEIGHT)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
