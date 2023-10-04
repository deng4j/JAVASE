package dzh.com.JavaSE.com.Thread.basic.interrupt;

/**
 * 当线程为了等待一些特定条件的到来时，一般会调用sleep函数、wait系列函数或者join（）函数来阻塞挂起当前线程。
 *
 * 比如让线程睡眠3s，等待条件达成。
 * 但是有可能在3s内条件己被满足，如果一直等到3s后再返回有点琅费时间，这时候可以调用该线
 * 程的interrupt（）方法，强制sleep方法抛出InterruptedException异常而返回，线程恢复到激
 * 活状态。
 */
public class Interrupt2 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("threadOne sleep 200s");
                    Thread.sleep(200_000);
                    System.out.println("threadOne awaking");
                } catch (InterruptedException e) {
                    System.out.println("thread is interrupted");
                    return;
                }
            }
        });

        threadOne.start();

        // 确保子线程进入休眠状态
        Thread.sleep(1000);

        // 打断子线程的休眠，唤醒thradOne
        threadOne.interrupt();

        // 等待子线程执行完毕
        threadOne.join();

        System.out.println("main is over");
    }
}
