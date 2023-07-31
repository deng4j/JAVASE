package dzh.com.JavaSE.com.Net.TCP.TCP3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("服务器开启");
        ServerSocket server = null;
        try {
             server=new ServerSocket(9999);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true){
            try {
                Socket accept = server.accept();
                ServerThread serverThread=new ServerThread(accept);
                new Thread(serverThread).start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
