package dzh.com.JavaSE.com.IO.AIO.AIO_net.TimeDemo;

import dzh.com.JavaSE.com.IO.AIO.AIO_net.TimeDemo.clientHandler.AsyncTimeClientHandler;

import java.io.IOException;

public class TimeClient {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        String host = "127.0.0.1";
        AsyncTimeClientHandler timeClient = new AsyncTimeClientHandler(host,port);
        new Thread(timeClient,"AIO-AsyncTimeClientHandler-001").start();
    }
}
