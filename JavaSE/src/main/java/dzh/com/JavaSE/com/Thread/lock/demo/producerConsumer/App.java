package dzh.com.JavaSE.com.Thread.lock.demo.producerConsumer;

public class App {
    public static void main(String[] args) {
        Foodie f=new Foodie();
        Cooker c=new Cooker();
        f.start();
        c.start();
    }
}
