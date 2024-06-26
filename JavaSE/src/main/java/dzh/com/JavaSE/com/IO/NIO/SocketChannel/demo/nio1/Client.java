package dzh.com.JavaSE.com.IO.NIO.SocketChannel.demo.nio1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel sc=SocketChannel.open();
        if (sc.connect(new InetSocketAddress("localhost",8080))) {
            System.out.println("waiting...");
            sc.write(StandardCharsets.UTF_8.encode("hello"));
            sc.write(Charset.defaultCharset().encode("the world"));
        }
    }
}
