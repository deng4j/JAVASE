package dzh.com.JavaSE.com.Net.demo.TCP.scoket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * ServerSocket是http协议
 * TCP是面向连接的
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务器指定端口
        ServerSocket server=new ServerSocket(8888);
        //接收客户端 阻塞式
        Socket socket = server.accept();
        //发送数据
        Scanner scanner=new Scanner(System.in);
        String msg=scanner.nextLine();
        /*BufferedWriter bw=new BufferedWriter(
                new OutputStreamWriter(
                        socket.getOutputStream()
                )
        );
        bw.write(msg);
        //逐行读取是阻塞式的
        bw.newLine();
        bw.flush();
        //服务器不关流*/
        //------使用DataOutputStream-------
        DataOutputStream dos=new DataOutputStream(
                new BufferedOutputStream(socket.getOutputStream())
        );
        dos.writeUTF(msg);
        dos.flush();
    }
}
