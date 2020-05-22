package Filter;

import MyExceptions.MyPluginException;

import java.awt.image.BufferedImage;

public interface IFilterCreator {

    IFilter getFilter(BufferedImage image, float[] args) throws MyPluginException;
}
