package dzh.com.JavaSE.com.Thread.countDownLatch;

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
         //当计数器为0后会唤醒这里等待的线程
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"洗碗");
    }
}
