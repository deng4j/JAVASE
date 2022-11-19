package JavaSE.com.Net.TCP.TCP2;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client=new Socket("localhost",9999);
        BufferedOutputStream os=new BufferedOutputStream( client.getOutputStream());
        //读取文件
        File file=new File("D:/idea/javas/src/com/Net/TCP/file/bzl.jpg");
        BufferedInputStream is=new BufferedInputStream(new FileInputStream(file));
        //长传文件
        byte[] bytes=new byte[8192];
        int len=0;
        while (-1!=(len=is.read(bytes))){
            os.write(bytes,0,len);
        }
        os.flush();
        //提示服务器传输完毕
        client.shutdownOutput();
    }
}
