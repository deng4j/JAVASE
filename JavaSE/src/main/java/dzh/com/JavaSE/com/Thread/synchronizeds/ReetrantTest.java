package dzh.com.JavaSE.com.Thread.synchronizeds;

/**
 * synchronized是一个可重入锁
 */
public class ReetrantTest {
    public synchronized void showA(){
        System.out.println("showA");
    }

    public synchronized void showB(){
        System.out.println("showB");
        showA(); // 测试是否可重入，获取自己已持有的锁，如果没被阻塞就是可重入
    }

    public static void main(String[] args) {
        ReetrantTest reetrantTest = new ReetrantTest();
        reetrantTest.showB();
    }
}
