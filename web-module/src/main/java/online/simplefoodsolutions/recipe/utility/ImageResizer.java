package online.simplefoodsolutions.recipe.utility;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageResizer
{
    public static BufferedImage resizeImage(BufferedImage originalImage, int width, int heigth, int type)
    {
        BufferedImage resizedImage = new BufferedImage(width, heigth, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, heigth, null);
        g.dispose();

        return resizedImage;
    }
}
