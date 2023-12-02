package dzh.com.JavaSE.com.Thread.JUC.thread_coordination.Semathpore;

import java.util.concurrent.Semaphore;

/**
 * 控制同一时间并发线程的数目。能够完成对于信号量的控制，可以控制某个资源可被同时访问的个数。
 *
 * Semaphore 维护了当前访问的个数，通过提供同步机制来控制同时访问的个数。Semaphore 可以实现有限大小的链表
 */
public class Car implements Runnable {
    //最多两辆车通行
    private Semaphore semaphore=new Semaphore(2);
    @Override
    public void run() {
        try {
            //获取通行证，如果没有则等待，可以一次获取多个
            semaphore.acquire();
            System.out.println("获得通行证");
            Thread.sleep(500);

            // 释放通行证，可以一次释放多个
            semaphore.release();
            System.out.println("归还通行证");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Car car=new Car();
        for (int i = 0; i < 10; i++) {
            new Thread(car).start();
        }
    }
}
