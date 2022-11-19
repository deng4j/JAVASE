package JavaSE.com.Jframe.Jframe1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class URL {

public Image getImage(String  path){
    java.net.URL uri=URL.class.getClassLoader().getResource(path);
    BufferedImage image=null;
    try {
        image=ImageIO.read(uri);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return image;

}
}
