package dzh.com.JavaSE.com.Net.demo.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入名称");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String name=br.readLine();
        if (name.equals("")){
            return;
        }
        Socket client=new Socket("localhost",9999);
        new Thread(new Send(client,name)).start();
        new Thread(new Receive(client)).start();

    }
}
