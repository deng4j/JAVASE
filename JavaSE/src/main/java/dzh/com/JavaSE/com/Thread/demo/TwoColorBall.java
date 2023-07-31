package dzh.com.JavaSE.com.Thread.demo;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class TwoColorBall implements Runnable{
    private  int[] arr=new int[6];
     AtomicInteger p=new AtomicInteger(0);
    @Override
    public void run() {
        int s=0;
        while (true) {
            synchronized (this) {
                if (p.get() == 100) {
                    System.out.println("从" + Thread.currentThread().getName() + "有" + s + "位");
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 5; i++) {
                    arr[i] = (int) (Math.random() * 33 + 1);
                    for (int j = 0; j < i; j++) {
                        if (arr[i] == arr[j]) {
                            i--;
                        }
                    }
                }
                arr[5] = (int) (Math.random() * 16 + 1);
                p.incrementAndGet();
                System.out.println("编号" + p.get() + "从" + Thread.currentThread().getName() + "入场！拿到的双色球彩票号码是:" +
                        Arrays.toString(arr));
                s++;
            }
        }

    }

    public static void main(String[] args) {
        TwoColorBall twoColorBall =new TwoColorBall();
        new Thread(twoColorBall,"后门").start();
        new Thread(twoColorBall,"前门").start();
    }
}
