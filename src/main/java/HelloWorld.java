import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

//import static sun.misc.Version.print;

public class HelloWorld {

    public static void main(String[] args) throws Exception {
        print(System.out);
    }

    //AIzaSyAVsgYg4j1C_Mh56TKGElF5aNFZ0pGh5c8
    public static void print(PrintStream out) {
        out.println("Hello, World!");
    }
}