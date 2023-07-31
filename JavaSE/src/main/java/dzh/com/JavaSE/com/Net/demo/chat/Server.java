package dzh.com.JavaSE.com.Net.demo.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<MyChannel> all=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        new Server().start();
    }

    public void start() throws IOException {
        ServerSocket server=new ServerSocket(9999);
        while (true){
            Socket client=server.accept();
            MyChannel channel=new MyChannel(client);
            all.add(channel);
            new Thread(channel).start();
        }
    }


    private class  MyChannel implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isRunning=true;
        private String name;

        public MyChannel(Socket client) {
            try {
                dis=new DataInputStream(client.getInputStream());
                dos=new DataOutputStream(client.getOutputStream());
                this.name=dis.readUTF();
                this.send("欢迎进入聊天室");
                sendOther(this.name+"进入了聊天室",true);


            } catch (IOException e) {
                CloseUtil.CloseAll(dos,dis);
                isRunning=false;
            }
        }
        /**
         * 读取数据
         */
        private String receive(){
            String msg="";
            try {
                msg=dis.readUTF();
            } catch (IOException e) {
                CloseUtil.CloseAll(dis);
                isRunning=false;
                all.remove(this);
            }
            return msg;
        }

        /**
         * 发送数据
         * @param msg
         */
        private void send(String msg){
            if (null==msg||msg.equals("")){
                return;
            }
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                CloseUtil.CloseAll(dos);
                isRunning=false;
                all.remove(this);
            }
        }

        /**
         * 发送给其他客户端
         */

        private void sendOther(String msg,boolean sys){
            //是否设置为私聊
            if (msg.startsWith("@")&&msg.indexOf(":")>-1){
                //获取name
                String name=msg.substring(1,msg.indexOf(":"));
                String content=msg.substring(msg.indexOf(":")+1);
                for (MyChannel other : all) {
                    if (other.name.equals(name)){
                        other.send(this.name+"对您悄悄地说"+content);
                    }
                    }
                }else {
                     for (MyChannel other : all) {
                         if (other==this){
                             continue;
                         }
                         if (sys){
                             other.send("系统信息"+msg);
                         }else {
                             //发送其他客户端
                             other.send(this.name+"对所有人说"+msg);
                         }
                }
            }
        }

        @Override
        public void run() {
            while (isRunning){
                sendOther(receive(),false);
            }
        }
    }
}
