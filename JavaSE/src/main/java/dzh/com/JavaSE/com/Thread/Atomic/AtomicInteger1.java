package dzh.com.JavaSE.com.Thread.Atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 在多线程自增i++是不安全的。使用AtomicInteger进行自增是原子性的，采用CAS算法。
 */
public class AtomicInteger1 implements Runnable{
    private volatile AtomicInteger ai=new AtomicInteger(10);

    @Override
    public void run() {
        while (ai.get()>0){
            int i = ai.decrementAndGet();
//            print1(i);
            print2(i);
        }
    }

    /**
     * 不需要上同步锁
     */
    public void print1(int i){
        System.out.println(Thread.currentThread().getName()+":"+i);
    }

    public synchronized void print2(int i){
        System.out.println(Thread.currentThread().getName()+":"+i);
    }

    public static void main(String[] args) {
        AtomicInteger1 syn = new AtomicInteger1();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            pool.submit(syn);
        }
        pool.shutdown();
    }
}
