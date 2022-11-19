package JavaSE.com.Net.UDP.UPD1;

import java.io.IOException;
import java.net.*;

/**
 * 1先要运行接收端，再运行发送端
 * 2
 */
public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket client=new DatagramSocket(8888);
        String str="我还没上车！！我还没上车！！！";
        byte[] bytes = str.getBytes();
        DatagramPacket packet=new DatagramPacket(bytes,bytes.length,InetAddress.getLocalHost(),9999);
        client.send(packet);
        client.close();
    }
}
