package JavaSE.com.IO.file;

import java.io.File;
import java.util.Arrays;

public class filter {

    public static void main(String[] args) {
        String path="D:/idea/bjsxt/src/com/io/file";
        File file=new File(path);
        printName(file);
        //根路径
        File[] roots=File.listRoots();
        System.out.println(Arrays.toString(roots));
    }
    //打印每个文件夹下的每个文件
    public static void printName(File file){

        if (null==file||!file.exists()){
            return;
        }
        System.out.println(file.getAbsolutePath());
        if (file.isDirectory()){
            for ( File f:file.listFiles()) {
                printName(f);
            }
        }
    }

}
