package JavaSE.com.Thread.basic.ithiema;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StaticMethod implements Runnable{


    public static void show(){
         int  a=0;
        System.out.println(a++);
    }

    @Override
    public void run() {
        show();
    }

    public static void main(String[] args) {
        StaticMethod staticMethod = new StaticMethod();

        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            pool.submit(staticMethod);
        }
        pool.shutdown();
    }
}
