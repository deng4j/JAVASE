package dzh.com.JavaSE.com.Thread.volatile_.volatile2;


/**
 * 指令重排序问题
 */
public class Volatile2 {
    private static int num = 0;
    private static boolean ready = false;

//    private static volatile boolean ready = false;

    public static void main(String[] args) throws InterruptedException {
        Thread rt = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    if (ready) {
                        System.out.println(num + num);
                    }
                }
            }
        });

        rt.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 这里可能会重排序
                num = 2;
                ready = true;
            }
        }).start();

        Thread.sleep(10);

        rt.interrupt();
    }
}
