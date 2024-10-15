package dzh.com.JavaSE.com.IO.NIO.Files;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadWrite {
    public static void main(String[] args) throws IOException {
        Path p = Paths.get("D:\\temp\\1.txt");
        ByteBuffer bb = ByteBuffer.wrap(Files.readAllBytes(p));
        Files.write(Paths.get("D:\\temp\\2.txt"), bb.array());
    }
}
