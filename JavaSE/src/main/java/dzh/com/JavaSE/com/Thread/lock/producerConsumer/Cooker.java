package dzh.com.JavaSE.com.Thread.lock.producerConsumer;

public class Cooker extends Thread{

    @Override
    public void run() {

        while (true){
            // 加锁对象
            synchronized (Desk.lock){
                if (Desk.count==0){
                    break;
                }else {
                    if (Desk.flag){
                        //如果有食物，停止生产
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else {
                        System.out.println("生产了食物");
                        Desk.flag=true;
                        Desk.lock.notifyAll();
                    }

                    }
                }
        }
    }
}
