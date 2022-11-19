package JavaSE.com.Thread.ProducerConsumer.pc1;

public class App {
    public static void main(String[] args) {
        Foodie f=new Foodie();
        Cooker c=new Cooker();
        f.start();
        c.start();
    }
}
