package dzh.com.JavaSE.com.Thread.JUC.lock.demo.producerConsumer;

public class Desk {
    public static boolean flag=false;
    public static int count=10;
    public static final Object lock=new Object();
}
