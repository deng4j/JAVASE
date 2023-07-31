package dzh.com.JavaSE.com.Thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Condition的signal唤醒和await等待
 */
public class Condition1 {
   private Lock lock=new ReentrantLock();
   private Condition condition=lock.newCondition();
   private int i;


    public void  even(){
        while (i<20){
            lock.lock();
            try {
                if (i%2==0){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                    i++;
                    //偶数打印完，唤醒偶数打印
                    condition.signal();
                }else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }

        }

    }

    public void  odd(){
        while (i<20){
            lock.lock();
            try {
                if (i%2!=0){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                    i++;
                    //奇数打印完，唤醒偶数打印
                    condition.signal();
                }else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }

        }

    }



    public static void main(String[] args) {
        Condition1 condition1=new Condition1();

        new Thread(new Runnable() {
            @Override
            public void run() {
                condition1.odd();
            }
        },"odd").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                condition1.even();
            }
        },"even").start();
    }



}
