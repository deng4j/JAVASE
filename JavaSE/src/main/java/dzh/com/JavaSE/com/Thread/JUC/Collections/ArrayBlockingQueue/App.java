package dzh.com.JavaSE.com.Thread.JUC.Collections.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 在java.util.concurrent包中，BlockingQueue阻塞队列很好的解决了多线程中，如何高效安全“传输”数据的问题。
 *
 * 生产者线程1往阻塞队列里面添加新的数据，当阻塞队列满的时候(针对有界队列)，生产线程1将会处于阻塞状态，直到消费线程2从队列中取走一个数据；
 * 消费者线程2从阻塞队列取数据，当阻塞队列空的时候，消费线程2将会处于阻塞状态，直到生产线程把一个数据放进去。
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
