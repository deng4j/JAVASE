package dzh.com.JavaSE.com.Thread.Pool;

import cn.hutool.core.thread.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池管理(线程统一调度管理)
 *
 * @author caliven
 * @date 2021/1/1
 */
public final class ThreadPoolManager {

    /**
     * 线程池维护线程的最少数量（IO密集型，线程数=CPU核心数/(1-阻塞系数)，阻塞系数一般为0.8~0.9）
     * private static final int SIZE_CORE_POOL = (int) (CPU_CORE / (1 - 0.9));
     */
    private static final int SIZE_CORE_POOL = 20;

    /**
     * CPU核心数
     * private static final int CPU_CORE = Runtime.getRuntime().availableProcessors();
     */
    /**
     * 线程池维护线程的最大数量
     * private static final int SIZE_MAX_POOL = SIZE_CORE_POOL * 2;
     */
    private static final int SIZE_MAX_POOL = 20;

    private static ThreadPoolManager sThreadPoolManager = new ThreadPoolManager();

    /**
     * 线程池（实质就是newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待）
     *
     * @param corePoolSize - 池中所保存的线程数，包括空闲线程。
     * @param maximumPoolSize - 池中允许的最大线程数。
     * @param keepAliveTime - 当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。
     * @param unit - keepAliveTime 参数的时间单位。
     * @param workQueue - 执行前用于保持任务的队列。此队列仅由保持 execute 方法提交的 Runnable 任务。
     * @param handler - 由于超出线程范围和队列容量而使执行被阻塞时所使用的处理程序。
     */
    private final ThreadPoolExecutor mThreadPool = new ThreadPoolExecutor(
        SIZE_CORE_POOL,
        SIZE_MAX_POOL,
        0L,
        TimeUnit.MILLISECONDS,
        new LinkedBlockingQueue<>(1024),
        new ThreadFactoryBuilder().setNamePrefix("XIANGHUI-ThreadPool-").build(),
        new ThreadPoolExecutor.AbortPolicy()
    );

    /**
     * 将构造方法访问修饰符设为私有，禁止任意实例化。
     */
    private ThreadPoolManager() {
    }

    /**
     * 线程池单例创建方法
     */
    public static ThreadPoolManager newInstance() {
        return sThreadPoolManager;
    }

    /**
     * 将线程池初始化，核心线程数量
     */
    public void perpare() {
        if (mThreadPool.isShutdown() && !mThreadPool.prestartCoreThread()) {
            int startThread = mThreadPool.prestartAllCoreThreads();
        }
    }

    /**
     * 向线程池中添加任务方法
     */
    public void addExecuteTask(Runnable task) {
        if (task != null) {
            mThreadPool.execute(task);
        }
    }

    /**
     * 判断是否是最后一个任务
     */
    protected boolean isTaskEnd() {
        if (mThreadPool.getActiveCount() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取缓存大小
     */
    public int getQueue() {
        return mThreadPool.getQueue().size();
    }

    /**
     * 获取线程池中的线程数目
     */
    public int getPoolSize() {
        return mThreadPool.getPoolSize();
    }

    /**
     * 获取已完成的任务数
     */
    public long getCompletedTaskCount() {
        return mThreadPool.getCompletedTaskCount();
    }

    /**
     * 关闭线程池，不在接受新的任务，会把已接受的任务执行完
     */
    public void shutdown() {
        mThreadPool.shutdown();
    }
}
