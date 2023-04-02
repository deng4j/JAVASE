package JavaSE.com.Net.demo.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable{
    //控制台输入流
    private BufferedReader console;
    //管道输出流
    private DataOutputStream dos;
    //线程控制
    private boolean isRuning=true;
    //名称
    private  String name;

    public Send() {
        console=new BufferedReader(new InputStreamReader(System.in));
    }

    public Send(Socket client, String name) {
        this();
        try {
            dos=new DataOutputStream(client.getOutputStream());
            this.name = name;
            Sendmsg(this.name);
        } catch (IOException e) {
            isRuning=false;
            CloseUtil.CloseAll(dos,console);
        }

    }
    /**
     * 从控制台接收数据
     */
    private String getMsgFromConsole(){
        try {
            return console.readLine();
        } catch (IOException e) {

        }
        return "";
    }

    /**
     * 从控制台接收数据
     * 发送数据
     * @param msg
     */
    private void Sendmsg(String msg) {
        if (null!=msg&&!msg.equals("")){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                isRuning=false;
                CloseUtil.CloseAll(dos,console);
            }
        }

    }


    @Override
    public void run() {
        while (isRuning){
            Sendmsg(getMsgFromConsole());
        }

    }
}
