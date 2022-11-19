package JavaSE.com.Thread.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Synchrogazed2 implements Runnable{
    private volatile AtomicInteger ai=new AtomicInteger(10);

    @Override
    public void run() {
        while (ai.get()>0){
            int i = ai.decrementAndGet();
            print2(i);
            //print1();
        }
    }

    public synchronized void print1(){
        System.out.println(Thread.currentThread().getName());
        while (true){
        }
    }

    public synchronized void print2(int i){
        System.out.println(Thread.currentThread().getName()+":"+i);
    }

    public static void main(String[] args) {
        Synchrogazed2 syn = new Synchrogazed2();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            pool.submit(syn);
        }
        pool.shutdown();
    }
}
