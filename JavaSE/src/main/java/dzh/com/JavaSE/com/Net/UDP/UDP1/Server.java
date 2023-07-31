package dzh.com.JavaSE.com.Net.UDP.UDP1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务器+端口
        DatagramSocket server=new DatagramSocket(9999);
        //接收数组
        byte[] bytes=new byte[1024];
        //封装成包
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        //接收并放进箱子
        server.receive(packet);
        //解析数据
        byte[] data = packet.getData();
        System.out.println(new String(data,0,data.length));
        //释放资源
        server.close();

    }
}
