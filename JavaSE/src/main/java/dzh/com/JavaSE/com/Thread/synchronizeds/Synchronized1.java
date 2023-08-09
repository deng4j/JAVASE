package dzh.com.JavaSE.com.Thread.synchronizeds;

/**
 * 悲观锁：synchronized总是从最坏的角度出发，认为每次获取数据的时候，别人都有可能修改。
 */
public class Synchronized1 implements Runnable{
    private int i=50;
    @Override
    public void run() {

          while (i>0){
              synchronized (Synchronized1.class){
                  if (i==0){
                      break;
                  }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"剩余:"+--i);
            }
        }
    }
}
class App{
    public static void main(String[] args) throws InterruptedException {
        Synchronized1 s1=new Synchronized1();
        Thread t1=new Thread(s1,"t1");
        Thread t2=new Thread(s1,"t2");
        Thread t3=new Thread(s1,"t3");
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}