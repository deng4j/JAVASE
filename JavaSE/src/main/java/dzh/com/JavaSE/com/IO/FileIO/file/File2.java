package dzh.com.JavaSE.com.IO.FileIO.file;

import java.io.File;
import java.io.IOException;

public class File2 {
    public static void main(String[] args) throws IOException {
        File directory = new File("");//设定为当前文件夹

        System.out.println(directory.getCanonicalPath());//获取标准的路径

        System.out.println(directory.getAbsolutePath());//获取绝对路径
    }
}
