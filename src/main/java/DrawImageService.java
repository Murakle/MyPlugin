import Filter.IFilter;
import Filter.ImageFilters;
import MyExceptions.MyPluginException;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.wm.impl.IdeBackgroundUtil;
import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawImageService {

    private static final String DEFAULT_PATH = "/Users/user/dev/ITMO/Instruments/MyPlugin/src/main/resources/META-INF/example_origin.jpg";
    private final String sourcePath;

    private DrawImageService(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    private DrawImageService() {
        this.sourcePath = DEFAULT_PATH;
    }

    public void Draw() throws IOException, MyPluginException {
        BufferedImage source = ImageIO.read(new File(sourcePath));
        String resultPath = "/Users/user/dev/ITMO/Instruments/MyPlugin/src/main/resources/META-INF/result.jpg";

        BufferedImage result = ImageFilters.BLUR_FILTER.getFilter(source, 1).apply().getResult();
        ImageIO.write(result, "jpg", new File(resultPath));
        PropertiesComponent properties = PropertiesComponent.getInstance();
        properties.setValue(IdeBackgroundUtil.EDITOR_PROP, resultPath);
        IdeBackgroundUtil.repaintAllWindows();
    }

    public static DrawImageService setPath(@Nullable String path) {
        return path == null ? new DrawImageService() : new DrawImageService(path);
    }
}
