package dzh.com.JavaSE.com.Thread.thread_coordination.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Child1 implements Runnable {
    private CountDownLatch countDownLatch;

    public Child1(CountDownLatch cdl) {
        this.countDownLatch=cdl;
    }

    @Override
    public void run() {
        for (int i = 1; i < 15; i++) {
            System.out.println(Thread.currentThread().getName()+"吃了第"+i+"个饺子");
        }
        //线程完毕会调用，计数器-1
        countDownLatch.countDown();
    }
}
