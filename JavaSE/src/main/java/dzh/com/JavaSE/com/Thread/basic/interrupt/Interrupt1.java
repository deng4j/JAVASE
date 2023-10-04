package dzh.com.JavaSE.com.Thread.basic.interrupt;

/**
 * 优雅退出线程
 */
public class Interrupt1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 如果当前线程被中断则退出
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "hello");
                }
            }
        });

        thread.start();

        // 主线程休眠1s，以便子线程输出
        Thread.sleep(1000);

        // 中断子线程
        System.out.println("I will interrupt thread");
        thread.interrupt();

        // 等待子线程执行完毕
        thread.join();
        System.out.println("main over");
    }
}
