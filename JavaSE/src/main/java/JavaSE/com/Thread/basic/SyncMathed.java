package JavaSE.com.Thread.basic;

/**
 * 同步方法的锁对象是this，静态同步方法的锁对象是类名.class
 */
public class SyncMathed implements Runnable{
    private int i=50;
    @Override
    public void run() {
        while (true){
            if ("t1".equals(Thread.currentThread().getName())){
                boolean flag = SyncMd();
                if (flag){
                    break;
                }
            }
            synchronized (this) {
                if ("t2".equals(Thread.currentThread().getName())) {
                    if (i == 0) {
                        break;
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "剩余：" + --i);

                }
            }
        }
    }

    private synchronized boolean SyncMd() {
        if (i==0){
            return true;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"剩余："+--i);
        return false;
    }

    public static void main(String[] args) {
        SyncMathed s=new SyncMathed();
        Thread t1=new Thread(s,"t1");
        Thread t2=new Thread(s,"t2");
        t1.start();
        t2.start();
    }
}
