package dzh.com.JavaSE.com.Net.TCP.ThreadSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(9999);
        //加入线程池，提高效率
        ThreadPoolExecutor pool=new ThreadPoolExecutor(3,5,60,TimeUnit.SECONDS,new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy()
                );
        while (true){
            //等待客户端连接
            Socket accept = server.accept();
            ThreadSocket ts=new ThreadSocket(accept);
           pool.submit(ts);
        }
    }
}
