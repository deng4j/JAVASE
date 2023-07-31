package dzh.com.JavaSE.com.Net.UDP.UDP2;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建服务器+端口
        DatagramSocket client=new DatagramSocket(8888);
        System.out.println("请输入");
        Scanner scanner=new Scanner(System.in);
        String str=null;
        while (true){
            str=scanner.nextLine();
            int i = 0;

            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
            }

            if (886== i){
                break;
            }
            byte[] bytes = str.getBytes();
            //一对多广播
            DatagramPacket packet=new DatagramPacket(bytes,bytes.length,InetAddress.getByName("255.255.255.255"),9999);
            client.send(packet);

        }
        client.close();
    }
}
