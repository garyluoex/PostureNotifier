package com.garyluoex.project.gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by kaluo on 3/27/17.
 */
public class ImageUtils {

    public static BufferedImage scaleImage(BufferedImage sourceImage, int imageWidth, int imageHeight) throws IOException {
        BufferedImage scaledImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        scaledImage.getGraphics().drawImage(sourceImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH), 0, 0, null);
        return scaledImage;
    }
}
