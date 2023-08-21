package dzh.com.JavaSE.com.Thread.Pool.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.newFixedThreadPool：创建一个定长的线程池，可以控制线程的最大并发数，超出的线程会在队列中等待。
 */
public class NewFixedThreadPool1 {
    public static void main(String[] args) throws InterruptedException {
        //创建一个指定最大值得线程池
        ExecutorService pool= Executors.newFixedThreadPool(5);

        Thread.sleep(100);
        for (int i = 0; i < 10; i++) {
            pool.execute(()-> System.out.println("fixed线程"+Thread.currentThread().getName()));
        }
        pool.shutdown();
    }
}
