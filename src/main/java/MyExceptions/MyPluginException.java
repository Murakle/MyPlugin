package MyExceptions;

public class MyPluginException extends Exception {
    private MyPluginException(String msg) {
        super(msg);
    }

    public static MyPluginException ImageNotFoundException(String path) {
        return new MyPluginException("Image with path [" + path + "] not found ");
    }

    public static MyPluginException NotEnoughArguments() {
        return new MyPluginException("Not enough arguments");
    }


}
