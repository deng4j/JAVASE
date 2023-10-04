package dzh.com.JavaSE.com.Thread.JUC.lock.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLock() 只有在调用时才可以获得锁。防止死锁
 */
public class DeathLockPrevent {
    public static void main(String[] args) {
        Lock lock1=new ReentrantLock();
        Lock lock2=new ReentrantLock();

        new Thread(()->{
            while (true){
                if (lock1.tryLock()){
                    try {
                        if (lock2.tryLock()){
                            try {
                                System.out.println("尔康");
                            } finally {
                                lock2.unlock();
                            }
                        }
                    } finally {
                        lock1.unlock();
                    }
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                if (lock2.tryLock()){
                    try {
                        if (lock1.tryLock()){
                            try {
                                System.out.println("紫薇");
                            } finally {
                                lock1.unlock();
                            }
                        }
                    } finally {
                        lock2.unlock();
                    }
                }
            }
        }).start();
    }
}
