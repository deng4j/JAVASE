package dzh.com.JavaSE.com.Thread.JUC.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁：
 *  读-读：共享
 *  写-写：互斥
 *  读-写：互斥
 */
public class ReentrantReadWriteLock1 {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void get() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":--获取到读锁--");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(Thread.currentThread().getName() + ":释放读锁");
            readLock.unlock();
        }
    }

    public void put() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":--获取到写锁--");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(Thread.currentThread().getName() + ":释放写锁");
            writeLock.unlock();
        }
    }


    public static void main(String[] args) {
        ReentrantReadWriteLock1 rw = new ReentrantReadWriteLock1();
        new Thread(() -> rw.get(), "r1").start();
        new Thread(() -> rw.get(), "r2").start();
        new Thread(() -> rw.put(), "w1").start();
        new Thread(() -> rw.put(), "w2").start();
    }
}
