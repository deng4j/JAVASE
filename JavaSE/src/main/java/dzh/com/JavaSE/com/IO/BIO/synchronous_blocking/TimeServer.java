package dzh.com.JavaSE.com.IO.BIO.synchronous_blocking;

import dzh.com.JavaSE.com.IO.BIO.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 同步阻塞式，没个请求都创建一个独立的线程
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        Integer port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port:"+port);
            Socket socket = null;
            while (true){
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (server!=null){
                System.out.println("The time server closed");
                server.close();
                server=null;
            }
        }
    }
}
