package dzh.com.JavaSE.com.Thread.JUC.Atomic;

import java.util.concurrent.atomic.LongAdder;

/**
 * 解决AtomicLong高并发情况下的性能缺陷
 * 原理：将一个变量分解为多个变量，让多个线程竞争多个变量。
 */
public class LongAdder1 {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        longAdder.increment();
        System.out.println(longAdder.longValue());
    }
}
