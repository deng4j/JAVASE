package JavaSE.com.Jframe.Jframe1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MyDailog extends JDialog {
    public MyDailog(){
        Container container=getContentPane();
        JLabel jLabel=new JLabel();
        jLabel.setText("你点击了我");
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(jLabel);

        setTitle("对话框");
        setBounds(200,10,200,100);
    }

    @Override
    public void paint(Graphics g) {
        icons icons=new icons(10,100,90,50);
        icons.DrawIcon(g);
    }


}

class Myframae extends Jframe{
    @Override
    public void getJframe() {
        super.getJframe();
        setTitle("MyDailog");
        JButton jButton=new JButton();
        jButton.setText("点我");
        jButton.setBackground(Color.CYAN);
        jButton.setBounds(200,100,100,50);
        ActionListener actionListener=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyDailog().setVisible(true);
            }
        };
        jButton.addActionListener(actionListener);

        Image image= new URL().getImage("Jframe/imgs/邓紫棋.jpg");
        add(jButton);//添加组件
        System.out.println("MyCountDownLatch----"+this);
    }

    @Override
    public void paint(Graphics g) {
        icons icons=new icons(10,100,90,50);
        icons.DrawIcon(g);
        System.out.println(g);
    }
    public static void main(String[] args) {
        Jframe myframae=new Myframae();
        myframae.getJframe();
    }

}
