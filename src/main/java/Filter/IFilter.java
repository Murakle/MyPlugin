package Filter;

import java.awt.image.BufferedImage;

public interface IFilter {
    FilterResult apply();

    @SuppressWarnings("UndesirableClassUsage")
    default BufferedImage copyImage(BufferedImage image) {
        return new BufferedImage(image.getColorModel(), image.getRaster(), image.isAlphaPremultiplied(), null);
    }
}
