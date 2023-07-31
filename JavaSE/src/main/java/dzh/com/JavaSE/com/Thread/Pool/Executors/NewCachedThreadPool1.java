package dzh.com.JavaSE.com.Thread.Pool.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * submit(Runnable)：返回一个 Future 对象。这个 Future 对象可以用来检查 Runnable 是否已经执行完毕。
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
