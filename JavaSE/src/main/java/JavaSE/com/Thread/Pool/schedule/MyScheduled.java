package JavaSE.com.Thread.Pool.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyScheduled {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello !!");
            }
        };
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        ScheduledExecutorService service = Executors
                .newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 3, 1, TimeUnit.SECONDS);
    }
}
