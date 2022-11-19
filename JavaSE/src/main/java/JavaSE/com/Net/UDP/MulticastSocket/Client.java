package JavaSE.com.Net.UDP.MulticastSocket;

import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket client=new DatagramSocket();
        String str="卧槽！卧槽！你个小垃圾你玩不起！你个小垃圾！你耍赖皮！你玩不起！你都不敢和我正面对抗" +
                "啊你还玩个屁！";
        byte[] bytes=str.getBytes();
        InetAddress address=InetAddress.getByName("224.0.1.0");
        DatagramPacket packet=new DatagramPacket(bytes,bytes.length,address,9999);
        client.send(packet);
        client.close();
    }
}
