package dzh.com.JavaSE.com.Thread.Pool.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.newCachedThreadPool：创建一个可缓存的线程池，如果线程池的大小超过了需要，可以灵活回收空闲线程，如果没有可回收线程，则新建线程
 */
public class NewCachedThreadPool1 {
    public static void main(String[] args) throws InterruptedException {
        //创建一个根据需要创建新线程的线程池，但在可用时将重新使用以前构造的线程。
        ExecutorService es= Executors.newCachedThreadPool();
        es.submit(()->{
            System.out.println("cached线程一");
        });
        Thread.sleep(100);
        es.submit(()->{
            System.out.println("cached线程二");
        });
        //线程池的销毁
        es.shutdown();
    }
}
