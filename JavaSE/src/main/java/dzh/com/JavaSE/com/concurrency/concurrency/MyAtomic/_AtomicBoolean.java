package dzh.com.JavaSE.com.concurrency.concurrency.MyAtomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class _AtomicBoolean {
    private static AtomicBoolean isHappened=new AtomicBoolean(false);

    //请求总数
    public static int clientTotal=5000;
    //同时并发执行线程数
    public static int threadTotal=200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        log.info("isHappened:{}",isHappened.get());
    }

    private static void test() {
        if (isHappened.compareAndSet(false,true)){
            log.info("execute");
        }

    }
}
