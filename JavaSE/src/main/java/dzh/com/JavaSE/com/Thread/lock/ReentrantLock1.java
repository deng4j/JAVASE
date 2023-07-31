package dzh.com.JavaSE.com.Thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrantLock1 implements Runnable{
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
        ReentrantLock1 s=new ReentrantLock1();
        Thread t1=new Thread(s,"t1");
        Thread t2=new Thread(s,"t2");
        t1.start();
        t2.start();
    }
}
