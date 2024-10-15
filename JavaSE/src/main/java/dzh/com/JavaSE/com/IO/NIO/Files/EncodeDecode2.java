package dzh.com.JavaSE.com.IO.NIO.Files;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * ANSI转UTF-8文件
 */
public class EncodeDecode2 {
    public static void main(String[] args) throws IOException {

        // Command.log是一个ANSI格式的文件
        String path = "D:\\temp\\log\\20241014\\输送机\\03\\Command.log";

        String newPath = "D:\\temp\\log\\20241014\\输送机\\03\\1.log";

        Path p = Paths.get(path);
        ByteBuffer bb = ByteBuffer.wrap(Files.readAllBytes(p));
        // 将字节码用ANSI解码
        CharBuffer cb = Charset.forName("GBK").decode(bb);
        System.out.println(cb);

        // 将已经正确编码的字符，编码为utf-8格式
        bb = StandardCharsets.UTF_8.encode(cb);
        Files.write(Paths.get(newPath), bb.array());

    }
}
