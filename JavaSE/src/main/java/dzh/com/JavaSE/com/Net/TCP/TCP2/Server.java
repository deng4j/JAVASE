package dzh.com.JavaSE.com.Net.TCP.TCP2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(9999);
        while (true) {
            Socket accept = server.accept();
            //从客户端读取文件
            BufferedInputStream is=new BufferedInputStream(accept.getInputStream());
            //拷贝到本地,UUID随机生成唯一的序号
            File file=new File("D:/idea/javas/src/com/Net/TCP/file/"+UUID.randomUUID().toString() +".jpg");
            BufferedOutputStream os=new BufferedOutputStream(new FileOutputStream(file));
            int len=0;
            byte[] bytes=new byte[8192];
            while (-1!=(len=is.read(bytes))){
                os.write(bytes,0,len);
            }
            os.flush();
            os.close();
            is.close();
            accept.close();
        }
    }
}
