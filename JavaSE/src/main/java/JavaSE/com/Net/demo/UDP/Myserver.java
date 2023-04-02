package JavaSE.com.Net.demo.UDP;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Myserver {
    public static void main(String[] args) throws IOException {
        //创建服务端+端口
        DatagramSocket server=new DatagramSocket(8888);
        //准备接收容器
        byte[] container=new byte[1024];
        //封住打包
        DatagramPacket packet=new DatagramPacket(container,container.length);
        //接收数据
        server.receive(packet);
        //分析数据
        byte[] data=packet.getData();
        double d = getRead(data);
        System.out.println(d);
        server.close();


    }

    private static double getRead(byte[] data) throws IOException {
        DataInputStream dis=new DataInputStream(
                new BufferedInputStream(
                        new ByteArrayInputStream(data)
                )
        );
        double d = dis.readDouble();
        dis.close();
        return d;
    }
}
