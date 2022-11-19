package JavaSE.com.Jframe.Jframe1;

import javax.swing.*;
import java.awt.*;


public class Jframe extends JFrame {

    public  void getJframe(){
        Container container=getContentPane();
        JLabel jLabel=new JLabel();
        container.add(jLabel);//添加组件
        setVisible(true);
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        System.out.println("Jframe-----"+this);
    }

}
