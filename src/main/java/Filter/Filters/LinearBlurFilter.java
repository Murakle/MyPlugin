package Filter.Filters;

import Filter.FilterResult;
import Filter.IFilter;

import java.awt.*;
import java.awt.image.BufferedImage;


public class LinearBlurFilter implements IFilter {
    private final BufferedImage image;
    private final float power;

    public LinearBlurFilter(BufferedImage image, float power) { //power from 0 to 1 (0 - no blur, 1- max blur)
        this.image = image;
        this.power = power;
    }

    @Override
    @SuppressWarnings("UseJBColor")
    public FilterResult apply() {
        BufferedImage result = copyImage(image);
        int boxSize = getBoxSize();
        float div = (float) 1 / (boxSize * boxSize);
        for (int i = 0; i < result.getWidth(); i++) {
            for (int j = 0; j < result.getHeight(); j++) {
                int r = 0, g = 0, b = 0;
                for (int k = 0; k < boxSize; k++) {
                    for (int l = 0; l < boxSize; l++) {
                        int x = normalize(i + (k - boxSize / 2), result.getWidth());
                        int y = normalize(j + (l - boxSize / 2), result.getHeight());
                        Color prevColor = new Color(image.getRGB(x, y));
                        r += prevColor.getRed();
                        g += prevColor.getGreen();
                        b += prevColor.getBlue();
                    }
                }
                result.setRGB(i, j, new Color(
                        normalize((int) (r * div), 255),
                        normalize((int) (g * div), 255),
                        normalize((int) (b * div), 255)).getRGB());
            }
        }
        return new FilterResult(result);
    }

    private int normalize(int number, int limitation) {
        return Math.min(limitation - 1, Math.max(number, 0));
    }

    private int getBoxSize() {
        int s = (int) (power * 10);
        return s + (s + 1) % 2;
    }
}
