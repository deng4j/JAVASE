package dzh.com.JavaSE.com.Thread.basic.createThread;

/**
 * 线程创建方式一
 *  缺点：拓展性差不能继承其他类
 *  优点：功能丰富
 *
 * 在同一个方法中，连续创建多个线程后，调用线程的start()方法的顺序并不能决定线程的执行顺序。
 *
 * start()方法使用 synchronized 关键字修饰，说明 start()方法是同步的，它会在启动线程前检查线程的状态，如果不
 * 是初始化状态，则直接抛出异常。所以，一个线程只能启动一次，多次启动是会抛出异常的。
 *
 * stop()方法会真的杀死线程。如果线程持有 ReentrantLock 锁，被stop()的线程并不会自动调用 ReentrantLock 的 unlock()去释放锁，
 * 那其他线程就再也没机会获得 ReentrantLock 锁， 这样其他线程就再也不能执行ReentrantLock 锁锁住的代码逻辑。 所以该方法就不建议使用了，
 * 类似的方法还有 suspend()和 resume()方法， 这两个方法同样也都不建议使用了
 *
 * interrupt()方法仅仅是通知线程中断。一个线程只能向另一个线程发送中断信号，而不能强行对其进行关闭。而另一个线程如何处理，就得看其正在执行的代码对中断信号如何反应了。
 * 被 interrupt 的线程，有两种方式接收通知：一种是异常， 另一种是主动检测。
 *  - interrupt() => 设置中断状态，设置为已中断
 *  - isInterrupted() => 获取中断状态
 *  - interrupted() => 恢复中断状态，并返回恢复前的状态。（即如果被中断，会设置为未中断，并返回true）
 */
public class Thread1 extends Thread {
    private  int i=10;
    @Override
    public void run() {
        print();
    }

    private void print() {
        while (i>0){
            System.out.println(currentThread().getName()+"--"+i--);
        }
    }

    public static void main(String[] args) {
        Thread1 m1=new Thread1();
        m1.setName("m1");
        Thread1 m2=new Thread1();
        m2.setName("m2");
        m1.start();
        m2.start();

        int i = Thread1.activeCount();
        System.out.println(i);
        ThreadGroup threadGroup = m1.getThreadGroup();
        System.out.println(threadGroup);
    }
}
