package JavaSE.com.Net.TCP.TCP1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务端+端口
        ServerSocket server=new ServerSocket(9000);
        //接收数据
        Socket accept = server.accept();
        //写数据
        BufferedWriter os=new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        //读出数据，accept阻塞的方法
        InputStream is =accept.getInputStream();
        byte[] bytes=new byte[1024];
        int len=0;
        //read阻塞方法，没有读到结束标注
        while (-1!=(len=is.read(bytes))){
            String str=new String(bytes,0,len);
            System.out.println(str);
            //回复,并给客户端一个结束符
            os.write("收到");
            os.newLine();
            os.flush();
        }
        //释放资源
        is.close();
        os.close();
//        service.close();
    }
}
