package dzh.com.JavaSE.com.Thread.volatile_.volatile1;

public class Boy implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Money.money=9000;
        System.out.println("boy 还剩9000");
    }
}
