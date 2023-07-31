package dzh.com.JavaSE.com.IO.BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClinet {
    public static void main(String[] args) {
        Integer port = 8080;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket("127.0.0.1",port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);

            out.println("query time order");
            String resp = in.readLine();
            System.out.println("Now is :" + resp);

            out.println("hello");
            String resp1 = in.readLine();
            System.out.println("Now is :" + resp1);
        } catch (IOException e) {

        }finally {
            if (out!=null){
                out.close();
                out=null;
            }
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
