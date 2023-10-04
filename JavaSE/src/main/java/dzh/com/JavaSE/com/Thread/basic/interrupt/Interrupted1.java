package dzh.com.JavaSE.com.Thread.basic.interrupt;

public class Interrupted1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) ;
            }
        });

        thread.start();

        // 设置中断标志
        thread.interrupt();

        // 获取中断标志
        System.out.println("isInterrupted:" + thread.isInterrupted());

        // 获取中断标志并重置
        System.out.println("interrupted:" + thread.interrupted());

        // 获取中断标志并重置
        System.out.println("interrupted:" + Thread.interrupted());

        // 获取中断标志
        System.out.println("isInterrupted:" + thread.isInterrupted());

        thread.join();
    }
}
