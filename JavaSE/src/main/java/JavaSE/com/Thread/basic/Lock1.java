package JavaSE.com.Thread.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *tryLock() 只有在调用时才可以获得锁。
 */
public class Lock1 implements Runnable{
    private int i=50;
    private Lock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                if (i == 0) {
                    break;
                }
                    Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "剩余：" + --i);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Lock1 s=new Lock1();
        Thread t1=new Thread(s,"t1");
        Thread t2=new Thread(s,"t2");
        t1.start();
        t2.start();
    }
}
