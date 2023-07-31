package dzh.com.JavaSE.com.Thread.Pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * shutdown 只是将空闲的线程 interrupt() 了，shutdown（）之前提交的任务可以继续
 * 执行直到结束。
 *
 * shutdownNow 是 interrupt 所有线程， 因此大部分线程将立刻被中断。之所以是大部分，
 * 而不是全部 ，是因为 interrupt()方法能力有限。
 */
public class ThreadPoolExecutor2 {
    public static void main(String[] args) {
        /**
         * ThreadPoolExecutor.AbortPolicy()丢弃超出部分，并抛出异常
         * ThreadPoolExecutor.DiscardPolicy丢弃超出部分，不抛异常
         * ThreadPoolExecutor.DIscardOldestpolicy()丢弃在等待队列中等待最久的任务
         * ThreadPoolExecutor.CallerRunsPolicy()超出部分任务绕过线程池直接运行
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
