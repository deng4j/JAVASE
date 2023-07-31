package dzh.com.JavaSE.com.Thread.Semathpore;

import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    //最多两辆车通行
    private Semaphore semaphore=new Semaphore(2);
    @Override
    public void run() {
        try {
            //获取通行证
            semaphore.acquire();
            System.out.println("获得通行证");
            Thread.sleep(100);

            semaphore.release();
            System.out.println("归还通行证");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
