package JavaSE.com.Net.TCP.TCP3;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket accept;

    public ServerThread(Socket accept) {
        this.accept=accept;
    }

    @Override
    public void run() {
        OutputStream os;
        try {
            File file=new File("D:/idea/javas/src/com/Net/TCP/TCP3/login.html");
             os =new BufferedOutputStream(accept.getOutputStream());
            InputStream is=new BufferedInputStream(new FileInputStream(file));

            // 写入HTTP协议响应头,固定写法
            os.write("HTTP/1.1 200 OK\r\n".getBytes());
            os.write("Content‐Type:text/html\r\n".getBytes());
            // 必须要写入空行,否则浏览器不解析
            os.write("\r\n".getBytes());

            byte[] bytes=new byte[8920];
            int len=0;
            while (-1!=(len=is.read(bytes))){
                os.write(bytes,0,len);
            }
            os.flush();
//            最后再shutdown
//            os.close();
            is.close();
            System.out.println("传输完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (accept!=null){
                try {
                    accept.shutdownOutput();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
