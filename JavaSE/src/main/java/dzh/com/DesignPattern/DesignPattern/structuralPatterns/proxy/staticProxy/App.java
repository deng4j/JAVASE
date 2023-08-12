package dzh.com.DesignPattern.DesignPattern.structuralPatterns.proxy.staticProxy;

public class App {
    public static void main(String[] args) {
        RealSubject realStar=new RealSubject();
        Proxy proxyStar=new Proxy(realStar);
        proxyStar.request();
    }
}
