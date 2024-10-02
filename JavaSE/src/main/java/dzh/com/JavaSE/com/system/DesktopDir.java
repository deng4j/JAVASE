package dzh.com.JavaSE.com.system;

import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class DesktopDir {
    public static void main(String[] args) {
        //当前用户桌面路径
        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
        String desktopPath = desktopDir.getAbsolutePath();
        System.out.println("desktopPath = " + desktopPath);
    }
}
