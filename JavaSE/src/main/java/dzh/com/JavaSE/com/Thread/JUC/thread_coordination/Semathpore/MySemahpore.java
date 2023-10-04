package dzh.com.JavaSE.com.Thread.JUC.thread_coordination.Semathpore;

/**
 * 控制同一时间并发线程的数目。能够完成对于信号量的控制，可以控制某个资源可被同时访问的个数。
 *
 * Semaphore 维护了当前访问的个数，通过提供同步机制来控制同时访问的个数。Semaphore 可以实现有限大小的链表
 */
public class MySemahpore {
    public static void main(String[] args) {
        Car car=new Car();
        for (int i = 0; i < 10; i++) {
            new Thread(car).start();
        }
    }
}
