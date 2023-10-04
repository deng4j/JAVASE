package dzh.com.JavaSE.com.Thread.basic.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程方式三：
 *  优点：有返回值
 */
public class Callable1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        int i=12;
        while (i>0){

            if (i==12){
                System.out.println(Thread.currentThread().getName()+"-学习到"+i+"点");
                i=1;
            }
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "-学习到" + i++ + "点");

            if (i==5)break;
        }
        return "要我的命";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable1 m=new Callable1();
        FutureTask<String> ft=new FutureTask<>(m);
        Thread t1=new Thread(ft);
        t1.start();
        //等待线程结束才有结果
        String s = ft.get();
        System.out.println(s);
    }

}
