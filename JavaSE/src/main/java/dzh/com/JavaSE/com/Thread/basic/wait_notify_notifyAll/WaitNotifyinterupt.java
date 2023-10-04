package dzh.com.JavaSE.com.Thread.basic.wait_notify_notifyAll;

public class WaitNotifyinterupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("---begin---");
                // 阻塞当前线程
                synchronized (this) {
                    try {
                        // 挂起该线程
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();

        Thread.sleep(1000);

        thread.interrupt();
        System.out.println("main over");
    }
}
