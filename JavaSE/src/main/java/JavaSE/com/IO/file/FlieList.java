package JavaSE.com.IO.file;

import java.io.File;

public class FlieList {

    public static void main(String[] args) {
        File file = new File("D:\\idea\\javas\\src\\com");
        File file1 = new File("D:\\ideasX\\JavaSE\\JavaSE\\src\\main\\java\\JavaSE\\com");

        File[] listFiles = file.listFiles();
        File[] listFiles1 = file1.listFiles();
        System.out.println(listFiles.length==listFiles1.length);
    }
}
