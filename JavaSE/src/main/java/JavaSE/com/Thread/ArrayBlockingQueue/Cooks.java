package JavaSE.com.Thread.ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Cooks implements Runnable {
    private ArrayBlockingQueue<String> queue;
    public Cooks(ArrayBlockingQueue<String> queue) {
        this.queue=queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                queue.put("汉堡包");
                System.out.println("做了一个汉堡包");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
