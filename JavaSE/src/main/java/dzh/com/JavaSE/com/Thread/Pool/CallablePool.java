package dzh.com.JavaSE.com.Thread.Pool;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import java.util.concurrent.*;

public class CallablePool {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor pool=new ThreadPoolExecutor(3,5,20,TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        Collection<Callable<String>> list=new ArrayList<>();

        list.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "金海湾";
            }
        });

        list.add(()->"铜锣湾");
        list.add(()->"海贼天堂");

        List<Future<String>> futures = pool.invokeAll(list, 1000, TimeUnit.SECONDS);
        System.out.println("执行了invoke方法");
        if (list instanceof RandomAccess){
            for (int i = 0; i < futures.size(); i++) {
                System.out.println(futures.get(i).get());
            }
        }else {
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        }
        pool.shutdown();
    }
}
