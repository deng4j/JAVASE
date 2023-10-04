package dzh.com.JavaSE.com.Thread.JUC.LockSupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupport2 {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 被中断才退出循环
                while (!Thread.currentThread().isInterrupted()){
                    LockSupport.park();
                }
                System.out.println("exit");
            }
        });
        thread1.start();

        Thread.sleep(5000);

        // 中断
        thread1.interrupt();
    }
}
