package dzh.com.JavaSE.com.Thread.JUC.thread_coordination.Semathpore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 模拟CyclicBarrier效果
 */
public class Semaphore1 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"A task over");
                semaphore.release();
            }
        });

        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"A task over");
                semaphore.release();
            }
        });

        semaphore.acquire(2); // 获取两个令牌

        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"B task over");
                semaphore.release();
            }
        });

        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"B task over");
                semaphore.release();
            }
        });

        semaphore.acquire(2); // 获取两个令牌

        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"C task over");
                semaphore.release();
            }
        });

        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"C task over");
                semaphore.release();
            }
        });

        pool.shutdown();
    }
}
