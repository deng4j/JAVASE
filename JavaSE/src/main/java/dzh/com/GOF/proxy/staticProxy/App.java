package dzh.com.GOF.proxy.staticProxy;

public class App {
    public static void main(String[] args) {
        RealStar realStar=new RealStar();
        ProxyStar proxyStar=new ProxyStar(realStar);
        proxyStar.sing();
    }
}