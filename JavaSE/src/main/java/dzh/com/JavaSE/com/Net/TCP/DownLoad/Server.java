package dzh.com.JavaSE.com.Net.TCP.DownLoad;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class Server {
    private static final byte endflag=0x04;
    public static void main(String[] args) throws IOException {
       ServerSocket server=new ServerSocket(10000);
        ThreadPoolExecutor pool=new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        while (true) {
            //阻塞等待连接
            Socket accept = server.accept();
            ThreadServer ts=new ThreadServer(accept);
            pool.submit(ts);
        }
    }
}
