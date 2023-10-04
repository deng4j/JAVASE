package dzh.com.JavaSE.com.Thread.JUC.ThreadLocalRandom;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 高并发随机数生成
 */
public class ThreadLocalRandom1 {
    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }
    }
}
