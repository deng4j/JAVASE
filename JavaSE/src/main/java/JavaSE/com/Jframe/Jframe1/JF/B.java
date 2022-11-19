package JavaSE.com.Jframe.Jframe1.JF;

import java.awt.*;

public class B extends A {
    @Override
    public void drawA() {
        super.drawA();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        Font f=new Font("微软雅黑", Font.BOLD, 50);
        g.setFont(f);
        System.out.println(g);
        g.drawString("大碗牙签",100,200);
    }

    public static void main(String[] args) {
        B b=new B();
        b.drawA();
    }
}
