package dzh.com.DesignPattern.DesignPattern.structuralPatterns.proxy.dynamicProxy.JDK;

public class App {
    public static void main(String[] args) throws Exception {
        Star realStar = new RealStar();
        Star proxy = (Star) new StarProxy().getInstance(realStar);
        proxy.sing();

        System.out.println("----------------------");

        System.out.println(proxy.getClass());
    }
}
