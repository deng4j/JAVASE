package dzh.com.JavaSE.com.system;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class DesktopDir {
    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        String desktopPath = "";
        if (osName.toLowerCase().contains("windows")) {
            desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
        } else {
            try {
                Process process = Runtime.getRuntime().exec("xdg-user-dir DESKTOP");
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                desktopPath = reader.readLine();
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(desktopPath);

    }
}
