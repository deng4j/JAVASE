package JavaSE.com.Net.demo.UDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Myclient {
    public static void main(String[] args) throws IOException {
        //创建客户端+端口
        DatagramSocket client=new DatagramSocket(9999);
        //准备数据
        String msg="udp发信息";
        byte[] bytes = msg.getBytes();
        double d=123.23;
        byte[] write = getWrite(d);
        //打包（发送的地点及端口）
        InetSocketAddress isa=new InetSocketAddress("localhost",8888);
        DatagramPacket packet=new DatagramPacket(write,write.length,isa);
        //发送
        client.send(packet);
        client.close();
    }

    private static byte[] getWrite(double d) throws IOException {
        byte[] bytes=null;
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        DataOutputStream dos=new DataOutputStream(
                new BufferedOutputStream(bos)
        );
        dos.writeDouble(d);
        dos.flush();
        bytes=bos.toByteArray();
        dos.close();
        return bytes;
    }


}
