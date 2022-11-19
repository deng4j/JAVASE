package concurrency.AQS;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class _ConditionLock {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        //等待信号
        new Thread(()->{
            try {
                reentrantLock.lock();
                //1.等待信号
                log.info("wait signal");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //4.得到信号
            log.info("get signal");
            reentrantLock.unlock();
        }).start();


        new Thread(()->{
            try {
                reentrantLock.lock();
                //2.得到锁
                log.info("get lock");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();
            //3.发送信号
            log.info("send signal");
            reentrantLock.unlock();
        }).start();
    }
}
