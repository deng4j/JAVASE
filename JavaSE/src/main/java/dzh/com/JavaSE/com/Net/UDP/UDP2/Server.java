package dzh.com.JavaSE.com.Net.UDP.UDP2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket server=new DatagramSocket(9999);
        byte[] bytes=new byte[1024];
        while (true) {
            DatagramPacket packet=new DatagramPacket(bytes,bytes.length);
            server.receive(packet);
            byte[] data = packet.getData();

            if (data.length==0){
                break;
            }
            System.out.println(new String(data,0,data.length));
        }


        server.close();
    }
}
