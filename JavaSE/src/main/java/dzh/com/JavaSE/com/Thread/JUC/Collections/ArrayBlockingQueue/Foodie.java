package dzh.com.JavaSE.com.Thread.JUC.Collections.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie implements Runnable {
    private ArrayBlockingQueue<String> queue;
    public Foodie(ArrayBlockingQueue<String> queue) {
        this.queue=queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                String take = queue.take();
                System.out.println("吃了一个"+take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
