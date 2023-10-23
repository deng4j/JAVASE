package dzh.com.JavaSE.com.Thread.Pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Thread 直接创建线程的弊端：
 *  1.每次 new Thread 新建对象，性能差。
 *  2.线程缺乏统一管理，可能无限制的新建线程，相互竞争，有可能占用过多系统资源导致死机或 OOM。
 *  3.缺少更多的功能，如更多执行、定期执行、线程中断。
 *
 * 线程池的好处:
 *  1.重用存在的线程，减少对象创建、消亡的开销，性能佳。
 *  2.可以有效控制最大并发线程数，提高系统资源利用率，同时可以避免过多资源竞争，避免阻塞。
 *  3.提供定时执行、定期执行、单线程、并发数控制等功能。
 *  4.提供支持线程池监控的方法，可对线程池的资源进行实时监控。
 *
 * 线程池几种状态:
 *  1.Running:运行状态，能接收新提交的任务，并且也能处理阻塞队列中的任务
 *  2.Shutdown: 关闭状态，不能再接收新提交的任务，但是可以处理阻塞队列中已经保存的任务，当线程池处于 Running 状态时，调用 shutdown()方法会使线程池进入该状态
 *  3.Stop: 不能接收新任务，也不能处理阻塞队列中已经保存的任务，会中断正在处理任务的线程，如果线程池处于 Running 或 Shutdown 状态，调用shutdownNow()方法，会使线程池进入该状态。
 *  4.Tidying: 如果所有的任务都已经终止，有效线程数为 0（阻塞队列为空，线程池中的工作线程数量为 0），线程池就会进入该状态。
 *  5.Terminated: 处于 Tidying 状态的线程池调用 terminated()方法，会使用线程池进入该状态
 *
 * 合理配置线程:
 *  1.CPU 密集型任务，就需要尽量压榨 CPU，参考值可以设置为NCPU+1(CPU 的数量加 1)。
 *  2.IO 密集型任务，参考值可以设置为 2*NCPU（CPU 数量乘以 2）
 */
public class ThreadPoolExecutor1 {

    /**
     * corePoolSize、maximumPoolSize、workQueue三个参数的关系如下所示：
     *  1.如果运行的线程数小于 corePoolSize，直接创建新线程处理任务，即使线
     *    程池中的其他线程是空闲的。
     *  2.如果运行的线程数大于等于 corePoolSize，并且小于maximumPoolSize，此时，只有当 workQueue 满时，
     *    才会创建新的线程处理任务。
     *  3.如果设置的 corePoolSize 与 maximumPoolSize 相同，那么创建的线程池大小是固定的，此时，如果有新任务提交，
     *    并且 workQueue 没有满时，就把请求放入到 workQueue 中，等待空闲的线程，从 workQueue 中取出任务进行处理。
     *  4.如果运行的线程数量大于 maximumPoolSize，同时，workQueue 已经满了，会通过拒绝策略参数 rejectHandler 来指定处理策略。
     *
     * 根据上述三个参数的配置，线程池会对任务进行如下处理方式：
     *  1.当提交一个新的任务到线程池时，线程池会根据当前线程池中正在运行的线程数量
     *    来决定该任务的处理方式。处理方式总共有三种：直接切换、使用无限队列、使用有界队列。
     *     - 直接切换常用的队列就是 SynchronousQueue。
     *     - 使用无限队列就是使用基于链表的队列，比如：LinkedBlockingQueue，如果使用这种方式，线程池中创建的最大线程数就是 corePoolSize，
     *       此时maximumPoolSize不会起作用，因为队列永远不会满。当线程池中所有的核心线程都是运行状态时，提交新任务，就会放入等待队列中。
     *     - 使用有界队列使用的是 ArrayBlockingQueue，使用这种方式可以将线程池的最大线程数量限制为 maximumPoolSize，可以降低资源的消耗。但
     *       是，这种方式使得线程池对线程的调度更困难，因为线程池和队列的容量都是有限的了。
     *
     * 根据上面三个参数，我们可以简单得出如何降低系统资源消耗的一些措施：
     *  1.如果想降低系统资源的消耗，包括 CPU 使用率，操作系统资源的消耗，上下文环境切换的开销等，可以设置一个较大的队列容量和较小的线程池容量。这
     *    样，会降低线程处理任务的吞吐量。
     *  2.如果提交的任务经常发生阻塞，可以考虑调用设置最大线程数的方法，重新设置线程池最大线程数。如果队列的容量设置的较小，通常需要将线程池的容量
     *    设置的大一些，这样，CPU 的使用率会高些。如果线程池的容量设置的过大，并发量就会增加，则需要考虑线程调度的问题，反而可能会降低处理任务的吞吐量。
     */
    public static void main(String[] args) {
        /**
         * 1.corePoolSize：核心线程数量。
         * 2.maximumPoolSize：最大线程数。
         * 3.keepAliveTime：空闲线程最大存活时间。当线程池中的线程数量大于 corePoolSize 时，如果此时没有新的任务提交，核
         *   心线程外的线程不会立即销毁，需要等待，直到等待的时间超过了keepAliveTime 就会终止。
         * 4.unit：keepAliveTime的时间单位
         * 5.workQueue：阻塞队列，存储等待执行的任务，很重要，会对线程池运行过程产生重大影响。
         * 6.threadFactory：线程工厂，用来创建线程默认会提供一个默认的工厂来创建线程，当使用默认的工厂来创建线程时，会使新
         *   创建的线程具有相同的优先级，并且是非守护的线程，同时也设置了线程的名称。
         * 7.RejectedExecutionHandler：任务拒绝策略，如果任务数量超出了最大线程数+队列容量，则超出部分会被拒绝。
         *    - ThreadPoolExecutor.AbortPolicy()丢弃超出部分，并抛出异常
         *    - ThreadPoolExecutor.DiscardPolicy丢弃超出部分，不抛异常
         *    - ThreadPoolExecutor.DIscardOldestpolicy()丢弃在等待队列中等待最久的任务
         *    - ThreadPoolExecutor.CallerRunsPolicy()超出部分任务绕过线程池直接运行
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
