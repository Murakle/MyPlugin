package Filter;

import Filter.FilterCreator.BlackWhite;
import Filter.FilterCreator.LinearBlur;
import MyExceptions.MyPluginException;

import java.awt.image.BufferedImage;


public enum ImageFilters {
    BLACK_WHITE(new BlackWhite()),
    BLUR_FILTER(new LinearBlur()),
    ;
    IFilterCreator creator;

    ImageFilters(IFilterCreator creator) {
        this.creator = creator;
    }

    public IFilter getFilter(BufferedImage image, float... args) throws MyPluginException {
        return creator.getFilter(image, args);
    }

}
