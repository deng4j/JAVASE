package JavaSE.com.Thread.Pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 可缓存线程的线程池，此方法返回 ThreadPoolExecutor
 * 执行定时任务的线程池，此方法返回 ScheduledThreadPoolExecutor
 * 可以拆分执行子任务的线程池，此方法返回 ForkJoinPool
 *
 *execute(Runnable):异步执行,没有执行结果。
 * submit(Runnable)：返回一个 Future 对象。这个 Future 对象可以用来检查 Runnable 是否已经执行完毕。
 *
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        //创建一个根据需要创建新线程的线程池，但在可用时将重新使用以前构造的线程。
        ExecutorService es=Executors.newCachedThreadPool();
        es.submit(()->{
            System.out.println("cached线程一");
        });
        Thread.sleep(100);
        es.submit(()->{
            System.out.println("cached线程二");
        });
        //线程池的销毁
        es.shutdown();
        //-------------------------创建一个指定最大值得线程池
        ExecutorService nftp= Executors.newFixedThreadPool(5);
          ThreadPoolExecutor pool= (ThreadPoolExecutor) nftp;
          Thread.sleep(100);
        for (int i = 0; i < 10; i++) {
            nftp.submit(()-> System.out.println("fixed线程"+Thread.currentThread().getName()));
        }


          System.out.println(pool.getPoolSize());
          nftp.shutdown();
    }
}
