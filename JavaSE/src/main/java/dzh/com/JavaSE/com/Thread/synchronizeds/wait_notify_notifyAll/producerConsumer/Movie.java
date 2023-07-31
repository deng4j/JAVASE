package dzh.com.JavaSE.com.Thread.synchronizeds.wait_notify_notifyAll.producerConsumer;

/**
 * 只能在同步代码块中调用wait()，nofity()和notifyAll(),因为这些方法都操作锁。
 *
 * wait()使当前线程进入等待队列，并释放该线程所拥有的锁，（而sleep()方法挂起当前线程，并不释放该线程所拥有的锁），等待某个条件发生变化，再由其他线程唤醒(notify)。
 * notify()用来唤醒由wait()引起的被挂起的线程，当一个线程调用notify()时，在众多等待同一个锁的任务中只有一个会被唤醒。
 * notifyAll()将唤醒所有等待当前线程所拥有的锁的线程，但只有一个被唤醒的线程获得锁。
 *
 * 当一个线程调用notifyAll()方法时，并不会立即释放锁，只有在同步代码块语句执行完后，才释放锁。
 */
public class Movie {
    private  boolean flag=false;
    public static int count=10;
    private String video;

    public synchronized void make(String video){
        if (flag){
            //up等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("剪辑了"+video);
            flag=true;
            this.video=video;
            this.notifyAll();
        }

    }
    public  synchronized void player(){
        if (flag){
            System.out.println("播放了"+"《"+video+"》");
            flag=false;
            count--;
            this.notifyAll();

        }else {
            //观众等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
