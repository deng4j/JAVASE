package JavaSE.com.Jframe.Jframe1;

import javax.swing.*;
import java.awt.*;

public class AbstractLayout extends JFrame {
    public AbstractLayout(){
        setTitle("绝对布局");
        setLayout(null);
        setBounds(0,0,200,150);
        Container c=getContentPane();
        JButton b1=new JButton("b1");
        JButton b2=new JButton("b2");
        b1.setBounds(10,20,80,30);
        b2.setBounds(40,60,60,25);
        c.add(b1);
        c.add(b2);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        System.out.println(this);
    }

    public static void main(String[] args) {
        new AbstractLayout();
    }
}
