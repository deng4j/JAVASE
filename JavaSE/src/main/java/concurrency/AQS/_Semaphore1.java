package concurrency.AQS;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class _Semaphore1 implements Runnable{
    /**
     * 一次最多允许4个线程通过
     */
    private static Semaphore semaphore=new Semaphore(4);
    private static int count=100;

    @Override
    public void run() {

        try {
            //尝试获取一个许可，允许等待一秒，没有获取到许可就丢弃
            if (semaphore.tryAcquire(1,TimeUnit.SECONDS)) {
                Thread.sleep(1000);
                //归还两个
                log.info("交钱"+count--);
                semaphore.release(2);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pool=new ThreadPoolExecutor(5,20,10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        _Semaphore1 latch=new _Semaphore1();
        for (int i = 0; i < 100; i++) {
            pool.submit(latch);
        }
        pool.shutdown();

    }

    }


