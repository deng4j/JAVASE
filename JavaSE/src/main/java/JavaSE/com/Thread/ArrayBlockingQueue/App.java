package JavaSE.com.Thread.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * LinkedBlockQueue无界限的，最大为int的最大值
 */

public class App {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue=new ArrayBlockingQueue<>(1);
        Cooks cooks=new Cooks(queue);
        Foodie foodie=new Foodie(queue);
        new Thread(cooks).start();
        new Thread(foodie).start();
    }
}
