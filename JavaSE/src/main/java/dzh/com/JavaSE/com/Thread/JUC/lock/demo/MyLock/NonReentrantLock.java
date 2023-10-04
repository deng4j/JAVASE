package dzh.com.JavaSE.com.Thread.JUC.lock.demo.MyLock;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 基于AQS实现一个不可重入的独占锁。
 * 重新定义AQS中state的含义：由于不可重入，所以不需要记录持有锁的线程获取锁的次数
 * 0：目前没有被线程持有
 * 1：锁已经被某一个线程持有
 */
public class NonReentrantLock implements Lock, Serializable {

    private final Sync sync = new Sync();

    private static class Sync extends AbstractQueuedSynchronizer {

        /**
         * 是否已经持有锁
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        /**
         * 如果state为0，尝试获取锁
         */
        @Override
        protected boolean tryAcquire(int arg) {
            if (arg != 1) {
                throw new RuntimeException("参数异常");
            }
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 尝试释放锁，设置state为0
         */
        @Override
        protected boolean tryRelease(int arg) {
            if (arg != 1) {
                throw new RuntimeException("参数异常");
            }
            if (getState() == 0) {
                // 说明锁已经被释放，抛异常
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }


    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    public static void main(String[] args) {
        NonReentrantLock lock = new NonReentrantLock();

        final int[] a = {10};

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (a[0] > 0) {
                    lock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + ":" + (a[0]--));
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }, "1").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (a[0] > 0) {
                    lock.lock();
                    try {
                        System.out.println(Thread.currentThread().getName() + ":" + (a[0]--));
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }, "2").start();
    }
}
