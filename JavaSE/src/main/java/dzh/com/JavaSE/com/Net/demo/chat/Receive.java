package dzh.com.JavaSE.com.Net.demo.chat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable {
    //输入流
    private DataInputStream dis;
    //线程标记
    private boolean isRunning=true;

    public Receive() {
    }

    public Receive(Socket client) {
        try {
            dis=new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            isRunning=false;
            CloseUtil.CloseAll(dis);
        }
    }

    /**
     * 接收数据
     */
    public  String receive(){
        String msg="";
        try {
            msg=dis.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            isRunning=false;
            CloseUtil.CloseAll(dis);
        }
        return msg;
    }



    @Override
    public void run() {
        while (isRunning){
            System.out.println(receive());
        }

    }
}
