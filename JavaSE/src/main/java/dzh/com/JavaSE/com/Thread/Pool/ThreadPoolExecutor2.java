package dzh.com.JavaSE.com.Thread.Pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * shutdown 只是将空闲的线程 interrupt() 了，shutdown（）之前提交的任务可以继续
 * 执行直到结束。
 * shutdownNow 是 interrupt 所有线程， 因此大部分线程将立刻被中断。之所以是大部分，
 * 而不是全部 ，是因为 interrupt()方法能力有限。
 *
 * submit(Runnable)：返回一个 Future 对象。这个 Future 对象可以用来检查 Runnable 是否已经执行完毕。
 * execute(Runnable):异步执行,没有执行结果。
 *
 * getTaskCount()：线程池已执行和未执行的任务总数
 * getCompletedTaskCount()：已完成的任务数量
 * getPoolSize()：线程池当前的线程数量
 * getCorePoolSize()：线程池核心线程数
 * getActiveCount():当前线程池中正在执行任务的线程数量
 */
public class ThreadPoolExecutor2 {
    public static void main(String[] args) {
        /**

         */
        ThreadPoolExecutor tpe=new ThreadPoolExecutor(3,5,
                10,TimeUnit.SECONDS,new ArrayBlockingQueue<>(2)
                ,Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i < 8; i++) {
            tpe.submit(()-> System.out.println(Thread.currentThread().getName()+"运行"));
        }
        //可能线程池销毁了，线程还没结束。销毁后还会执行所有任务
        tpe.shutdown();
        //shutdownNow会中断sleep方法，会出现睡眠中断异常
        System.out.println("end");
    }
}
