package dzh.com.JavaSE.com.Thread.Pool.Executors.schedule;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

/**
 * 定时任务工具类：
 * schedule时间片是5s，那么理论上会在5、10、15、20这些时间片被调度，
 * 但是如果由于某些CPU征用导致未被调度，假如等到第8s才被第一次调度，
 * 那么schedule方法计算出来的下一次时间应该是第13s而不是第10s，
 * 这样有可能下次就越到20s后而被少调度一次或多次，
 * 而scheduleAtFixedRate方法就是每次理论计算出下一次需要调度的时间用以排序，
 * 若第8s被调度，那么计算出应该是第10s，所以它距离当前时间是2s，
 * 那么再调度队列排序中，会被优先调度，那么就尽量减少漏掉调度的情况。
 */
 public class TimingTask {
    private static final ConcurrentMap<String, ScheduledFuture> timingTaskMap = new ConcurrentHashMap<>();
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private static final Map<Long, String> taskhistorical = new HashMap<>();

    /**
     * 创建一个定时任务
     *
     * @param taskName     任务名称
     * @param initialDelay 延时开始
     * @param period       执行周期
     * @param command      任务线程
     * @param mandatory    (存在)强制创建
     */
    public static boolean CreateTimingTask(String taskName, long initialDelay,
                                           long period, Runnable command, boolean mandatory) {
        if (FindTimingTask(taskName)) {
            System.out.println("定时任务存在。");
            if (mandatory) {
                System.out.println("强制创建");
                CancelTimingTask(taskName);
                ScheduledFuture future = scheduler.scheduleAtFixedRate(command, initialDelay, period, TimeUnit.SECONDS);
                timingTaskMap.put(taskName, future);
                return true;
            } else {
                return false;
            }
        }
        ScheduledFuture future = scheduler.scheduleAtFixedRate(command, initialDelay, period, TimeUnit.SECONDS);
        timingTaskMap.put(taskName, future);
        return true;
    }


    /**
     * 创建一个一次性的延迟任务
     *
     * @param initialDelay 延时开始
     * @param command      任务线程
     */
    public static void CreateTask(String name, long initialDelay, Runnable command) {
        try {
            scheduler.schedule(command, initialDelay, TimeUnit.SECONDS);
            taskhistorical.put(System.currentTimeMillis(), name);
        } catch (Exception e) {
            System.out.println("任务执行失败");
        }
    }

    /**
     * 根据名称查询定时任务
     *
     * @param taskName 任务名称
     * @return true任务存在  false任务取消
     */
    public static boolean FindTimingTask(String taskName) {

        try {
            ScheduledFuture scheduledFuture = timingTaskMap.get(taskName);
            if (scheduledFuture != null) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * 根据名称取消定时任务
     *
     * @param taskName 任务名称
     */
    public static boolean CancelTimingTask(String taskName) {
        try {
            if (FindTimingTask(taskName)) {
                boolean b = timingTaskMap.get(taskName).cancel(true);
                timingTaskMap.remove(taskName);
                return b;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

     /**
      * 查询定时任务列表
      *
      * @return 任务名称集合
      */
     public static Set<String> FindListTimingTask() {
         return timingTaskMap.keySet();
     }


    public static void main(String[] args) {
        Runnable task = new Runnable() {

            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        TimingTask.CreateTimingTask("任务",1L,3L,task,false);
    }
}