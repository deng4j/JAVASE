package dzh.com.JavaSE.com.Thread.lock.demo.producerConsumer;

public class Foodie extends Thread{
    @Override
    public void run() {
       while (true){
           synchronized (Desk.lock){
               if (Desk.count==0){
                   break;
               }else {
                   if (Desk.flag){
                       System.out.println("吃食物");
                       Desk.flag=false;
                       Desk.lock.notifyAll();
                       Desk.count--;
                   }else {
                       try {
                           Desk.lock.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }
           }
       }
    }
}
