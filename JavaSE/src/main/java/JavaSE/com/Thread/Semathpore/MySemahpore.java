package JavaSE.com.Thread.Semathpore;

/**
 * 可以控制访问特定资源的线程数量。
 */
public class MySemahpore {
    public static void main(String[] args) {
        Car car=new Car();
        for (int i = 0; i < 10; i++) {
            new Thread(car).start();
        }
    }
}
