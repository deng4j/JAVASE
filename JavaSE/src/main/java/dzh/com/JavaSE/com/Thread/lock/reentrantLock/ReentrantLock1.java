package dzh.com.JavaSE.com.Thread.lock.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * ReentrantLock可重入锁
 *
 * ReentrantLock和synchronized都是同一个线程进入 1 次，锁的计数器就自增 1，需要等到锁的计数器下降为 0 时，才能释放锁。
 *
 * synchronized 优化之前性能比 ReentrantLock 差很多，但是自从 synchronized 引入了偏向锁，轻量级锁也就是自旋锁后，性能就差不多了。
 *
 * 锁的灵活度和细粒度优于 synchronized
 *
 * ReentrantLock 独有的功能：
 *  1.ReentrantLock 可指定是公平锁还是非公平锁。而 synchronized 只能是非公平锁。所谓的公平锁就是先等待的线程先获得锁。
 *  2.提供了一个 Condition 类，可以分组唤醒需要唤醒的线程。而synchronized 只能随机唤醒一个线程，或者唤醒全部的线程
 *  3.提供能够中断等待锁的线程的机制，lock.lockInterruptibly()。ReentrantLock 实现是一种自旋锁，通过循环调用 CAS 操作来实现加锁，
 *    性能上比较好是因为避免了使线程进入内核态的阻塞状态。
 *
 * boolean tryLock():仅在调用时锁定未被另一个线程保持的情况下才获取锁定。
 * boolean tryLock(long, TimeUnit): 如果锁定在给定的等待时间内没有被另一个线程保持，且当前线程没有被中断，则获取这个锁定。
 * void lockInterruptibly():如果当前线程没有被中断，就获取锁定；如果被中断，就抛出异常。
 * boolean isLocked():查询此锁定是否由任意线程保持。
 * boolean isHeldByCurrentThread(): 查询当前线程是否保持锁定状态。
 * boolean isFair():判断是否是公平锁。
 * boolean hasQueuedThread(Thread)：查询指定线程是否在等待获取此锁定。
 * boolean hasQueuedThreads():查询是否有线程正在等待获取此锁定。
 * boolean getHoldCount():查询当前线程保持锁定的个数。
 */
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
