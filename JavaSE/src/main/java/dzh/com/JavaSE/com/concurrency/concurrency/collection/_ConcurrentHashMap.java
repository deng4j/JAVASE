package dzh.com.JavaSE.com.concurrency.concurrency.collection;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class _ConcurrentHashMap {
    private static ConcurrentHashMap<Integer,Integer> concurrentHashMap=new ConcurrentHashMap<>();

    //请求总数
    public static int clientTotal=5000;
    //同时并发执行线程数
    public static int threadTotal=200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int count=i;
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    test(count);
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception",e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        log.info("isHappened:{}",concurrentHashMap.size());
    }

    private static void test(int i) {
        concurrentHashMap.put(i,i);
    }
}
