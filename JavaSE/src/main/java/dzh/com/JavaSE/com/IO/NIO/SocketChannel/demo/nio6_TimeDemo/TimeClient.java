package dzh.com.JavaSE.com.IO.NIO.SocketChannel.demo.nio6_TimeDemo;

public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        String host = "localhost";
        MultiplexerTimeClientHandle timeClientHandle = new MultiplexerTimeClientHandle(host,port);
        new Thread(timeClientHandle,"TimeClient-001").start();
    }
}
