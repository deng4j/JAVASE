package dzh.com.JavaSE.com.IO.BIO.pseudo_asynchronous;

import dzh.com.JavaSE.com.IO.BIO.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 线程池实现伪异步，避免每个请求都创建一个独立的线程，但底层的通信依旧采用同步阻塞模型，
 * 依旧无法从根本上解决问题
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        Integer port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port:"+port);
            Socket socket = null;
            TimeServerHandlerExcutePool singleExecutor = new TimeServerHandlerExcutePool(50,10000);
            while (true){
                socket = server.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
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
