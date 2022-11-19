package concurrency.AQS;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class _Semaphore implements Runnable{
    /**
     * 一次最多允许4个线程通过
     */
    private static Semaphore semaphore=new Semaphore(4);
    private static int count=100;

    @Override
    public void run() {

        try {
            //一次拿两个通行证
            semaphore.acquire(2);
            log.info("通行:"+(count--));

            Thread.sleep(100);

            //归还两个
            log.info("交钱");
            semaphore.release(2);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pool=new ThreadPoolExecutor(5,20,10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        _Semaphore latch=new _Semaphore();
        for (int i = 0; i < 100; i++) {
            pool.submit(latch);
        }
        pool.shutdown();

    }

    }


