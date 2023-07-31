package dzh.com.JavaSE.com.IO.NIO.SocketChannel.demo.nio6_TimeDemo;

public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        MultiplexerTimeServerHandler timeHandler = new MultiplexerTimeServerHandler(port);
        new Thread(timeHandler,"TimeServer-001").start();
    }
}
