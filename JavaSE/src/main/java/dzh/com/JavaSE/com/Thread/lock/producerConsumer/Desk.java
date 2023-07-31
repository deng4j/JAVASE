package dzh.com.JavaSE.com.Thread.lock.producerConsumer;

public class Desk {
    public static boolean flag=false;
    public static int count=10;
    public static final Object lock=new Object();
}
