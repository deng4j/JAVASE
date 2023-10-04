package dzh.com.JavaSE.com.Thread.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试静态方法
 */
public class StaticMethod implements Runnable{

    private static int a = 0;
    public static void show(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        a++;
        System.out.println(a);
    }

    @Override
    public void run() {
        show();
    }

    public static void main(String[] args) {
        StaticMethod staticMethod = new StaticMethod();

        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 50; i++) {
            pool.submit(staticMethod);
        }
        pool.shutdown();
    }
}
