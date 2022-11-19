package JavaSE.com.Net.TCP.ThreadSocket;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class ThreadSocket implements Runnable{
    private Socket acceptSocket;
    public ThreadSocket(Socket accept) {
        this.acceptSocket=accept;
    }


    @Override
    public void run() {
        //从客户端读取文件
        BufferedInputStream is= null;
        BufferedOutputStream os=null;
        try {
            is = new BufferedInputStream(acceptSocket.getInputStream());
            //拷贝到本地,UUID随机生成唯一的序号
            File file=new File("D:/idea/javas/src/com/Net/TCP/file/"+UUID.randomUUID().toString() +".jpg");
             os=new BufferedOutputStream(new FileOutputStream(file));
            int len=0;
            byte[] bytes=new byte[8192];
            while (-1!=(len=is.read(bytes))){
                os.write(bytes,0,len);
            }
            os.flush();

        } catch (IOException e) {

        }finally {
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (acceptSocket!=null){
                try {
                    acceptSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }

    }
}
