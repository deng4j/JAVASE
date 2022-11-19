package JavaSE.com.Net.Inet.TCP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient extends JFrame {
    private PrintWriter writer;
    Socket socket;
    private JTextArea ta=new JTextArea();
    private JTextField tf=new JTextField();
    Container cc;
    public MyClient(String title){
        super(title);
        //设置关闭窗口
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cc=this.getContentPane();
        final  JScrollPane scrollPane=new JScrollPane();
        scrollPane.setViewportView(ta);
        cc.add(tf,"South");
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writer.print(tf.getText());
                ta.append(tf.getText()+'\n');
                ta.setSelectionEnd(ta.getText().length());
                tf.setText("");
            }
        });


    }
    private  void connect(){
        ta.append("尝试连接\n");
            try {
                socket=new Socket("127.0.0.1",8998);
                writer=new PrintWriter(socket.getOutputStream(),true);
                ta.append("完成连接\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public static void main(String[] args) {
        MyClient myClient=new MyClient("向服务器发送数据");
        myClient.setSize(200,200);
        myClient.setVisible(true);
        myClient.connect();
    }
}
