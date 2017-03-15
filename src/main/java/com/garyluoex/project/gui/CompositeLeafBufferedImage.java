package com.garyluoex.project.gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.garyluoex.project.config.Configuration.*;

/**
 * Created by kaluo on 3/14/17.
 */
public class CompositeLeafBufferedImage extends BufferedImage {

    private BufferedImage greenLeafImage;
    private BufferedImage redLeafImage;
    private int imageWidth;
    private int imageHeight;

    public CompositeLeafBufferedImage(String greenLeaf, String redLeaf) throws IOException {
        super(LEAF_WIDTH, LEAF_HEIGHT, BufferedImage.TYPE_INT_ARGB);

        this.imageWidth = LEAF_WIDTH;
        this.imageHeight = LEAF_HEIGHT;
        this.greenLeafImage = loadImage(greenLeaf);
        this.redLeafImage = loadImage(redLeaf);
        this.getGraphics().drawImage(greenLeafImage, 0, 0, null);
    }

    public CompositeLeafBufferedImage(BufferedImage greenLeaf, BufferedImage redLeaf) throws IOException {
        super(LEAF_WIDTH, LEAF_HEIGHT, BufferedImage.TYPE_INT_ARGB);

        this.imageWidth = LEAF_WIDTH;
        this.imageHeight = LEAF_HEIGHT;

        this.greenLeafImage = greenLeaf;
        this.redLeafImage = redLeaf;

        this.getGraphics().drawImage(greenLeafImage, 0, 0, null);
        this.getGraphics().drawImage(redLeafImage, 0, 0, null);
    }

    private BufferedImage loadImage(String leafLocation) throws IOException {
        BufferedImage image = ImageIO.read(new File(leafLocation));
        BufferedImage scaledImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        scaledImage.getGraphics().drawImage(image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH), 0, 0, null);
        return scaledImage;
    }

    public CompositeLeafBufferedImage getNewOpacityImage(float opacity) throws IOException {
        BufferedImage alphaImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D alphaGraphics = alphaImage.createGraphics();
        alphaGraphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        alphaGraphics.drawImage(redLeafImage,null, 0, 0);
        return new CompositeLeafBufferedImage(greenLeafImage, alphaImage);
    }
}
