package Filter.Filters;

import Filter.FilterResult;
import Filter.IFilter;

import java.awt.*;
import java.awt.image.BufferedImage;


public class BlackWhiteFilter implements IFilter {
    private final BufferedImage image;

    public BlackWhiteFilter(BufferedImage image) {
        this.image = image;
    }

    @Override
    @SuppressWarnings("UseJBColor")
    public FilterResult apply() {
        BufferedImage result = copyImage(image);
        for (int i = 0; i < result.getWidth(); i++) {
            for (int j = 0; j < result.getHeight(); j++) {
                Color prev = new Color(image.getRGB(i, j));
                int dw = (prev.getRed() + prev.getGreen() + prev.getBlue()) / 3;
                Color newColor = new Color(dw, dw, dw);
                result.setRGB(i, j, newColor.getRGB());
            }
        }
        return new FilterResult(result);
    }
}
