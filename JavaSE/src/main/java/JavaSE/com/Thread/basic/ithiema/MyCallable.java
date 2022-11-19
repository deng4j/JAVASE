package JavaSE.com.Thread.basic.ithiema;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        int i=12;
        while (i>0){

            if (i==12){
                System.out.println(Thread.currentThread().getName()+"-学习到"+i+"点");
                i=1;
            }
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "-学习到" + i+++ "点");

            if (i==5)break;
        }
        return "要我的命";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable m=new MyCallable();
        FutureTask<String> ft=new FutureTask<>(m);
        Thread t1=new Thread(ft);
        t1.start();
        //等待线程结束才有结果
        String s = ft.get();
        System.out.println(s);
    }

}
