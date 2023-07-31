package dzh.com.JavaSE.com.Thread.lock;

/**
 * 使用jps和jstack查看进程
 */
public class DeathLock {
    public static void main(String[] args) {
        Object o1=new Object();
        Object o2=new Object();

        new Thread(()->{
            while (true){
                synchronized (o1){
                    System.out.println("小康进入o1锁");
                    synchronized (o2){
                        System.out.println("小康进入o2锁");
                    }
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                synchronized (o2){
                    System.out.println("小血进入o2锁");
                    synchronized (o1){
                        System.out.println("小血进入o1锁");
                    }
                }
            }
        }).start();
    }
}
