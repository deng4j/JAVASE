package dzh.com.tools.utils;

import java.io.File;

public class CreateFolder {

    public static void main(String[] args) {
        //生成文件夹
        String pathname = "D:\\ideasX\\project8\\bulls-stock\\aa-doc\\讲义";
        for (int i = 1; i < 18; i++) {
            File file = new File(pathname, "day" + i);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        System.out.println("文件夹创建结束");
    }
}
