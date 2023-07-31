package dzh.com.JavaSE.com.concurrency.AQS;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 工作窃取算法，自己的任务做完了，帮别人做，从后往前做（任务拆分）。
 */
@Slf4j
public class _ForkJoinTask extends RecursiveTask<Integer> {

    public static final int threshold=2;
    private int start;
    private int end;

    public _ForkJoinTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum=0;
        //如果任务足够小就计算任务
        boolean canCompute=(end-start)<=threshold;
        if (canCompute){
            for (int i=start;i<=end;i++){
                sum+=i;
            }
        }else {
            //如果任务大于阈值，就分裂成两个子任务计算
            int middle=(start+end)/2;
            _ForkJoinTask left = new _ForkJoinTask(start, middle);
            _ForkJoinTask right = new _ForkJoinTask(middle+1, end);
            //执行子任务
            left.fork();
            right.fork();
            //等待任务执行结束合并其结果
            sum=left.join()+right.join();
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //生成一个计算任务
        _ForkJoinTask task = new _ForkJoinTask(1, 100);
        ForkJoinTask<Integer> submit = forkJoinPool.submit(task);

        try {
            log.info("result{}",submit.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
