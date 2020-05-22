import Filter.ImageFilters;
import MyExceptions.MyPluginException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

//import static sun.misc.Version.print;

public class HelloWorld {

    public static void main(String[] args) throws Exception {
        Draw("/Users/user/dev/ITMO/Instruments/MyPlugin/src/main/resources/META-INF/example_origin.jpg");
    }

    public static void Draw(String sourcePath) throws IOException, MyPluginException {
        BufferedImage source = ImageIO.read(new File(sourcePath));
        String resultPath = "/Users/user/dev/ITMO/Instruments/MyPlugin/src/main/resources/META-INF/result.jpg";

        BufferedImage result = ImageFilters.BLUR_FILTER.getFilter(source, 1.0f).apply().getResult();
        ImageIO.write(result, "jpg", new File(resultPath));
//        PropertiesComponent properties = PropertiesComponent.getInstance();
//        properties.setValue(IdeBackgroundUtil.EDITOR_PROP, resultPath);
//        IdeBackgroundUtil.repaintAllWindows();
    }

    //AIzaSyAVsgYg4j1C_Mh56TKGElF5aNFZ0pGh5c8
    public static void print(PrintStream out) {
        out.println("Hello, World!");
    }
}