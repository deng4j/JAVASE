package JavaSE.com.Thread.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 使用CyclicBarrier会在 cyclicBarrier.await();这里阻塞，然后等待所有线程准备完成
 */
public class MyCyclicBarrier implements Runnable{
    /**
     * 所有参与线程数
     */
    private CyclicBarrier cyclicBarrier;

    public MyCyclicBarrier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void startThread(){
        //打印线程准备启动
        String name=Thread.currentThread().getName();
        System.out.println(name+"：正在准备。。。");
        //调用cyclicBarriar的await方法等线程全部准备完成
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name+"准备完毕");
    }


    @Override
    public void run() {
        startThread();
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
        MyCyclicBarrier cyclicBarrier1=new MyCyclicBarrier(cyclicBarrier);
        MyCyclicBarrier cyclicBarrier2=new MyCyclicBarrier(cyclicBarrier);
        MyCyclicBarrier cyclicBarrier3=new MyCyclicBarrier(cyclicBarrier);
        new Thread(cyclicBarrier1).start();
        new Thread(cyclicBarrier2).start();
        new Thread(cyclicBarrier3).start();

    }
}
