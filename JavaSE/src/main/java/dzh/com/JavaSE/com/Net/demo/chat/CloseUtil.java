package dzh.com.JavaSE.com.Net.demo.chat;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtil {
    public static void CloseAll(Closeable... io){
        for (Closeable closeable : io) {
            if (closeable!=null){
                try {
                    closeable.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
