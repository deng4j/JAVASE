package dzh.com.JavaSE.com.Thread.basic;

/**
 * 缺点：不能直接使用Thread类中的方法
 */
public class Runnable1 implements Runnable {
    private  int i=100;
    @Override
    public void run() {
        while (true){
            if (i<0)break;
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+"--"+i--);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Runnable1 m1=new Runnable1();
        Thread t1=new Thread(m1,"m1");
        Thread t2=new Thread(m1,"m2");
        Thread t3=new Thread(m1,"m3");
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        //
        Thread[] MR= {t1,t2};
        int i = Thread.enumerate(MR);
        System.out.println(i);
    }
}
