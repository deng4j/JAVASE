package dzh.com.JavaSE.com.IO.NIO.SocketChannel.demo.nio5_UDP;

import dzh.com.JavaSE.com.IO.NIO.utils.ByteBufferUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * server 这边的 receive 方法会将接收到的数据存入 byte buffer，但如果数据报文超过 buffer 大小，多出来的数据会被默默抛弃
 */
public class UdpServer {
    public static void main(String[] args) {
        try (DatagramChannel channel = DatagramChannel.open()) {
            channel.socket().bind(new InetSocketAddress(9999));
            System.out.println("waiting...");
            ByteBuffer buffer = ByteBuffer.allocate(32);
            channel.receive(buffer);
            buffer.flip();
            ByteBufferUtil.debugAll(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}