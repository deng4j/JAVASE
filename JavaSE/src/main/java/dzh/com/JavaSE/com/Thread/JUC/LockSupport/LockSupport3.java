package dzh.com.JavaSE.com.Thread.JUC.LockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * 和park()一样，只不过blocker会被记录到线程内部。
 *
 * 使用jps查出pid，使用jstack pid可以看到：
 *  - parking to wait for  <0x0000000698bed298> (a dzh.com.JavaSE.com.Thread.JUC.LockSupport.LockSupport3$1)
 */
public class LockSupport3 {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("begin park");
                LockSupport.park(this);
                System.out.println("end park");
            }
        });
        thread1.start();

        thread1.join();
    }
}
