package dzh.com.JavaSE.com.Thread.Pool.Executors.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Executors.newScheduledThreadPool：创建一个定长的线程池，支持定时、周期性的任务执行。
 *
 * 是多线程模式，并且重用线程池，某个ScheduledFutureTask 任务执行的时间比较久，不会影响到其他任务的调度执行
 *
 * ScheduledThreadPoolExecutor 调度是基于相对时间的，不受操作系统时间改变的影响。
 *
 * ScheduledThreadPoolExecutor 基于线程池来实现调度功能，某个任务抛出异常后，其他任务仍能正常执行。
 *
 * ScheduledThreadPoolExecutor 中执行的 ScheduledFutureTask类实现了 java.lang.Comparable 接口和java.util.concurrent.Delayed 接口，
 * 说明任务可以排序，也就具有优先级
 *
 * ScheduledThreadPoolExecutor 中执行的 ScheduledFutureTask类继承了 FutureTask 类，能够通过 Future 来获取返回的结果。
 */
public class NewScheduledThreadPool1 {
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
