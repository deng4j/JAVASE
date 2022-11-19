package JavaSE.com.Jframe.Jframe1;

import java.awt.*;

public class icons  {
    private  int width;
    private int heigth;
    private  int x;
    private  int y;

    public icons(int width, int heigth, int x, int y) {
        this.width = width;
        this.heigth = heigth;
        this.x = x;
        this.y = y;
    }

    public  void  DrawIcon(Graphics g){
        g.setColor(Color.red);
        Font f=new Font("微软雅黑", Font.BOLD, 50);
        g.setFont(f);
        g.drawString("大碗牙签",width,heigth);
    }


}
