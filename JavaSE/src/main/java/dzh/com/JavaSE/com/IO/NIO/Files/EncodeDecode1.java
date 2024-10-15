package dzh.com.JavaSE.com.IO.NIO.Files;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class EncodeDecode1 {
    public static void main(String[] args) {
        try {
            // Command.log是一个ANSI格式的文件
            Path filePath = Paths.get("D:\\temp\\log\\20241014\\输送机\\03\\Command.log");
            Files.lines(filePath, Charset.forName("CP1252")).forEach(s -> {
                try {
                    s = new String(s.getBytes("CP1252"), "GBK");
                    System.out.println(s);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
