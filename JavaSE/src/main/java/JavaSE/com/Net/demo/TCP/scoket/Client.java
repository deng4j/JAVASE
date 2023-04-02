package JavaSE.com.Net.demo.TCP.scoket;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端
        Socket client=new Socket("localhost",8888);

        //接收数据
        /*BufferedReader br=new BufferedReader(
                new InputStreamReader(client.getInputStream())
        );
        StringBuilder sb=new StringBuilder();
        String msg=null;
        try {
            while (null!=(msg=br.readLine())){
                sb.append(msg);
            }
        } catch (SocketException e) {

        }
        System.out.println(sb);*/

        //------使用DataOutputStream接收数据
        DataInputStream dis=new DataInputStream(
                new BufferedInputStream(client.getInputStream())
        );
        String msg = dis.readUTF();
        System.out.println(msg);
    }
}
