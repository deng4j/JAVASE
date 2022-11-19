package concurrency.AQS;

import java.util.concurrent.*;

/**
 * 模拟200个用户同时运行发送了5000个请求
 */

public class CountExample implements Runnable {
    private Semaphore semaphore=new Semaphore(200);
    private static   int count=0;

    @Override
    public void run() {
                try {
                    semaphore.acquire();
                    Thread.sleep(10);
                    count++;
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    }


    public static void main(String[] args) {
        ThreadPoolExecutor pool=new ThreadPoolExecutor(10,20,10,TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100),Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        CountExample countExample=new CountExample();
        for (int i = 0; i < 5000; i++) {
            pool.submit(countExample);
        }
        pool.shutdown();
        System.out.println(count);

    }
}
