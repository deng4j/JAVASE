package JavaSE.com.Thread.assaultThread.notifyAndWait;

/**
 * notify与wait和synchronized依赖使用
 */
public class OddEven1 {
   private Object obj=new Object();
   private int i;


    public void  even(){
        while (i<20){
            synchronized (obj){
                if (i%2==0){
                    System.out.println(Thread.currentThread().getName()+":"+i);
                    i++;
                    //偶数打印完，唤醒偶数打印
                    obj.notify();
                }else {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

   public void  odd(){
       while (i<20){
           synchronized (obj){
               if (i%2!=0){
                   System.out.println(Thread.currentThread().getName()+":"+i);
                   i++;
                   //奇数打印完，唤醒偶数打印
                   obj.notify();
               }else {
                   try {
                       obj.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }
       }

   }

    public static void main(String[] args) {
        OddEven1 oddEven=new OddEven1();

        new Thread(new Runnable() {
            @Override
            public void run() {
                oddEven.odd();
            }
        },"odd").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                oddEven.even();
            }
        },"even").start();
    }



}
