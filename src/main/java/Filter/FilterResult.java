package Filter;

import java.awt.image.BufferedImage;

public class FilterResult {
    private final BufferedImage result;

    public FilterResult(BufferedImage result) {
        this.result = result;
    }

    public BufferedImage getResult() {
        return result;
    }

}
