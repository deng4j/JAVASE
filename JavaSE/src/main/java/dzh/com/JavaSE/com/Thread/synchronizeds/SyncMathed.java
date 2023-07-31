package dzh.com.JavaSE.com.Thread.synchronizeds;

import lombok.SneakyThrows;

/**
 * 同步方法的锁对象是this，静态同步方法的锁对象是类名.class
 */
public class SyncMathed implements Runnable{
    private static int i=10;
    @Override
    public void run() {
        while (true){
            if (i<=0) return;
            syncMd();
            if (i<=0) return;
            syncStaticMd();
        }
    }

    @SneakyThrows
    private synchronized void syncMd() {
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"-syncMd剩余："+i--);
    }

    @SneakyThrows
    private static synchronized void syncStaticMd() {
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"-syncStaticMd剩余："+i--);
    }

    public static void main(String[] args) {
        SyncMathed s=new SyncMathed();
        Thread t1=new Thread(s,"t1");
        Thread t2=new Thread(s,"t2");
        t1.start();
        t2.start();
    }
}
