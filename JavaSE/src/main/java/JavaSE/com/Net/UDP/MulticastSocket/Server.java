package JavaSE.com.Net.UDP.MulticastSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        //创建接收端socket对象（MulticastSocket）
        MulticastSocket ms=new MulticastSocket(9999);
        //把当前计算机绑定一个组播地址，表示添加到这一组中
        ms.joinGroup(InetAddress.getByName("224.0.1.0"));
        byte[] bytes = new byte[1024];

        while (true) {
            DatagramPacket packet=new DatagramPacket(bytes,bytes.length);
            ms.receive(packet);
            //解析
            byte[] data = packet.getData();
            if (data.length==0){
                break;
            }
            System.out.println(new String(data,0,data.length));
        }

        ms.close();
    }
}
