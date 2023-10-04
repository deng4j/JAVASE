package dzh.com.JavaSE.com.Thread.JUC.thread_coordination.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Mother implements Runnable {
    private CountDownLatch countDownLatch;

    public Mother(CountDownLatch cdl) {
        this.countDownLatch=cdl;
    }

    @Override
    public void run() {
        //等待
        try {
            // 一直阻塞，直到计数器为0后会唤醒
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"洗碗");
    }
}
