package dzh.com.JavaSE.com.concurrency.AQS;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class _CyclicBarrier implements Runnable{

    private static CyclicBarrier cyclicBarrier=new CyclicBarrier(5,()->{
        log.info("优先执行这个runnable");
    });
    private static volatile int count=100;

    @Override
    public void run() {

        try {
            Thread.sleep(100);
            log.info("准备..."+count--);
            //等待2秒后不等了
            cyclicBarrier.await(2000,TimeUnit.MILLISECONDS);
            log.info("开始！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pool=new ThreadPoolExecutor(5,20,10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        _CyclicBarrier latch=new _CyclicBarrier();
        for (int i = 0; i < 100; i++) {
            pool.submit(latch);
        }
        pool.shutdown();

    }

    }


