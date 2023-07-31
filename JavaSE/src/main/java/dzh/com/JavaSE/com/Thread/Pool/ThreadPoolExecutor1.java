package dzh.com.JavaSE.com.Thread.Pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutor1 {
    public static void main(String[] args) {
        /**
         * 1.核心线程数量
         * 2.最大线程数量
         * 3.空闲线程最大存活时间
         * 4.时间单位
         * 5.任务队列,让多出来的任务在队列中等待
         * 6.创建线程工厂，按照默认的方式创建线程对象
         * 7.任务拒绝策略，如果任务数量超出了最大线程数+队列容量，则超出部分会被拒绝
         */
        ThreadPoolExecutor tpe=new ThreadPoolExecutor(3,5,
                10,TimeUnit.SECONDS,new ArrayBlockingQueue<>(5)
                ,Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            tpe.submit(()-> System.out.println(Thread.currentThread().getName()+"运行"));
        }
        tpe.shutdown();

    }
}
