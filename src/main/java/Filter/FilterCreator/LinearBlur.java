package Filter.FilterCreator;

import Filter.Filters.LinearBlurFilter;
import Filter.IFilter;
import Filter.IFilterCreator;
import MyExceptions.MyPluginException;

import java.awt.image.BufferedImage;

public class LinearBlur implements IFilterCreator {
    @Override
    public IFilter getFilter(BufferedImage image, float[] args) throws MyPluginException {
        if (args.length < 1) {
            throw MyPluginException.NotEnoughArguments();
        }
        return new LinearBlurFilter(image, args[0]);
    }
}
