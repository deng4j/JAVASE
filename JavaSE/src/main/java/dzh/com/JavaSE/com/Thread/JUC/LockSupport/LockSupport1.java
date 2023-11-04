package dzh.com.JavaSE.com.Thread.JUC.LockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport是一个基于Unsafe的工具类，用于挂起和唤醒线程，是创建锁和其他同步类的基础。
 *
 * void park()：如果调用park方法的线程拿到了LockSupport关联的许可证，则调用LockSupport.park()时会马上返回，
 * 否则调用线程会被禁止参与与线程的调度，也就是被阻塞挂起。默认情况下调用线程是不持有许可证的。
 *  其他线程调用unpark(Thread thread)，以该线程作为参数时，可以唤醒该线程。
 *  如果其他线程调用了该线程的interrupt()方法，该线程会返回，不会抛异常。
 *
 * void unpark(Thread thread)：当一个线程调用unpark时，如果入参thread线程没有持有thread与LockSupport关联的许可证，则让thread线程持有。
 *  如果之前thread因为调用park()而被挂起，则会被唤醒。
 *  如果之前thread没有被挂起，调用park()会立刻返回。
 */
public class LockSupport1 {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("begin park");
                LockSupport.park();
                System.out.println("end park");
            }
        });
        thread1.start();

        Thread.sleep(5000);

        LockSupport.unpark(thread1);
    }
}
