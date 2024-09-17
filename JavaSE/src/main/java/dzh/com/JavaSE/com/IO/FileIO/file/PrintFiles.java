package dzh.com.JavaSE.com.IO.FileIO.file;

import java.io.File;
import java.util.Arrays;

public class PrintFiles {

    public static void main(String[] args) {
        String path = "D:\\temp";
        File file = new File(path);
        printName(file);
        //根路径
        File[] roots = File.listRoots();
        System.out.println(Arrays.toString(roots));
    }

    //打印每个文件夹下的每个文件
    public static void printName(File file) {

        if (null == file || !file.exists()) {
            return;
        }
        System.out.println(file.getAbsolutePath());
        if (file.isDirectory()) {
            // 不读取隐藏文件
            for (File f : file.listFiles(o -> !o.isHidden())) {
                printName(f);
            }
        }
    }

}
