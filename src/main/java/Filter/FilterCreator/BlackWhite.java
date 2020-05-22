package Filter.FilterCreator;

import Filter.Filters.BlackWhiteFilter;
import Filter.IFilter;
import Filter.IFilterCreator;

import java.awt.image.BufferedImage;

public class BlackWhite implements IFilterCreator {
    @Override
    public IFilter getFilter(BufferedImage image, float[] args) {
        return new BlackWhiteFilter(image);
    }
}
