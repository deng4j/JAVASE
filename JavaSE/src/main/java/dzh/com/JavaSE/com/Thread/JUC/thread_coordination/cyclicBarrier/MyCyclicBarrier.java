package dzh.com.JavaSE.com.Thread.JUC.thread_coordination.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 使用CyclicBarrier会在 cyclicBarrier.await();这里阻塞，然后等待所有线程准备完成
 *
 * 与 CountDownLatch 有相似的地方，都是使用计数器实现，当某个线程调用了CyclicBarrier 的 await()方法后，该线程就进入了等待状态，
 * 而且计数器执行加 1 操作，当计数器的值达到了设置的初始值，调用 await()方法进入等待状态的线程会被唤醒，继续执行各自后续的操作。
 * CyclicBarrier 在释放等待线程后可以重用，所以，CyclicBarrier 又被称为循环屏障。
 */
public class MyCyclicBarrier implements Runnable {
    /**
     * 所有参与线程数
     */
    private CyclicBarrier cyclicBarrier;

    public MyCyclicBarrier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void startThread() {
        String name = Thread.currentThread().getName();
        try {
            System.out.println(name + "：进入第一阶段");
            //调用cyclicBarriar的await方法等线程全部准备完成

            cyclicBarrier.await();

            System.out.println(name + "：进入第二阶段");
            //调用cyclicBarriar的await方法等线程全部准备完成

            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + "完毕");
    }


    @Override
    public void run() {
        startThread();
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        MyCyclicBarrier cyclicBarrier1 = new MyCyclicBarrier(cyclicBarrier);
        MyCyclicBarrier cyclicBarrier2 = new MyCyclicBarrier(cyclicBarrier);
        MyCyclicBarrier cyclicBarrier3 = new MyCyclicBarrier(cyclicBarrier);
        new Thread(cyclicBarrier1).start();
        new Thread(cyclicBarrier2).start();
        new Thread(cyclicBarrier3).start();

    }
}
