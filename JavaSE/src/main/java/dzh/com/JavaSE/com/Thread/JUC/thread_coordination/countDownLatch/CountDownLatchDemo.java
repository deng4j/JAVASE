package dzh.com.JavaSE.com.Thread.JUC.thread_coordination.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 同步辅助类，通过它可以阻塞当前线程。也就是说，能够实现一个线程或者多个线程一直等待，直到其他线程执行的操作完成。
 *
 * 使用一个给定的计数器进行初始化，该计数器的操作是原子操作，即同时只能有一个线程操作该计数器。
 *
 * 调用该类 await()方法的线程会一直阻塞，直到其他线程调用该类的countDown()方法，使当前计数器的值变为 0 为止。每次调用该类的
 * countDown()方法，当前计数器的值就会减 1。当计数器的值减为 0 的时候，所有因调用 await()方法而处于等待状态的线程就会继续往下执行。
 * 这种操作只能出现一次，因为该类中的计数器不能被重置。
 *
 * CountDownLatch 支持给定时间的等待，超过一定的时间不再等待。public boolean await(long timeout, TimeUnit unit)
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        //计数器的值为3
        CountDownLatch cdl=new CountDownLatch(3);

        Mother mother=new Mother(cdl);
        new Thread(mother,"妈妈").start();

        Child1 child1=new Child1(cdl);
        new Thread(child1,"大娃").start();

        Child2 child2=new Child2(cdl);
        new Thread(child2,"二娃").start();

        Child3 child3=new Child3(cdl);
        new Thread(child3,"三娃").start();

    }
}
