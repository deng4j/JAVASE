package concurrency.AQS;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class _CountDownLatch implements Runnable{

    private static CountDownLatch countDownLatch=new CountDownLatch(20);

    @Override
    public void run() {

        synchronized (this) {
            countDownLatch.countDown();
            log.info("count--");
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pool=new ThreadPoolExecutor(5,20,10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        _CountDownLatch latch=new _CountDownLatch();
        for (int i = 0; i < 20; i++) {
            pool.submit(latch);
        }
        pool.submit(()->{
            try {
                //等待10毫秒没有执行完就执行。
                countDownLatch.await(10,TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("finish");
        });
        pool.shutdown();

    }

    }


