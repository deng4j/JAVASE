package dzh.com.JavaSE.com.IO.NIO.Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesMethods {
    public static void main(String[] args) throws IOException {
        //检查文件是否存在
        Path path = Paths.get("helloword/data.txt");
        System.out.println(Files.exists(path));

        /**
         * 创建一级目录
         * - 如果目录已存在，会抛异常
         * - 不能一次创建多级目录，否则会抛异常
         */
        Path path1 = Paths.get("helloword/d1");
        Files.createDirectory(path1);

        //创建多级目录
        Path path2 = Paths.get("helloword/d1/d2");
        Files.createDirectories(path2);

        /**
         * 拷贝文件
         * - 如果文件已存在，会抛异常
         * - 如果希望用 source 覆盖掉 target，需要用 StandardCopyOption来控制：Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
         */
        Path source = Paths.get("helloword/data.txt");
        Path target = Paths.get("helloword/target.txt");

        Files.copy(source, target);

        /**
         * 移动文件
         */
        Path source1 = Paths.get("helloword/data.txt");
        Path target1 = Paths.get("helloword/data.txt");

        Files.move(source1, target1, StandardCopyOption.ATOMIC_MOVE); //StandardCopyOption.ATOMIC_MOVE保证文件移动的原子性

        //删除文件，如果文件不存在，会抛异常
        Path target2 = Paths.get("helloword/target.txt");
        Files.delete(target2);

        //删除目录，如果目录还有内容，会抛异常
        Path target3 = Paths.get("helloword/d1");

        Files.delete(target3);

    }
}
