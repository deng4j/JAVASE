package dzh.com.JavaSE.com.system;

import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class SysDir {
    public static void main(String[] args) {
        //当前用户主页路径
        File homeDir = FileSystemView.getFileSystemView().getHomeDirectory();
        String homePath = homeDir.getAbsolutePath();
        System.out.println("homePath = " + homePath);
    }
}
