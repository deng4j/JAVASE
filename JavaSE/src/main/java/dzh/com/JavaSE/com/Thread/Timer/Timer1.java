package dzh.com.JavaSE.com.Thread.Timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * JDK 1.5 之前，实现任务的周期性调度主要使用的是 Timer 类和 TimerTask 类。
 *
 * Timer 是单线程模式，如果某个 TimerTask 任务的执行时间比较久，会影响到其他任务的调度执行。
 *
 * Timer 调度是基于操作系统的绝对时间的，对操作系统的时间敏感，一旦操作系统的时间改变，则 Timer 的调度不再精确
 *
 * Timer 不会捕获 TimerTask 抛出的异常，加上 Timer 又是单线程的。一旦某个调度任务出现异常，则整个线程就会终止，其他需要调度的任务也不再执行
 *
 * Timer 中执行的 TimerTask 任务整体上没有优先级的概念，只是按照系统的绝对时间来执行任务
 *
 * Timer 不支持对任务的排序。
 *
 * Timer 中执行的 TimerTask 类只是实现了 java.lang.Runnable 接口，无法从 TimerTask 中获取返回的结果。
 */
public class Timer1 {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("测试 Timer 类");
            }
        }, 1000, 1000);
        Thread.sleep(10000);
        timer.cancel();
    }
}