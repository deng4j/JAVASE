package dzh.com.JavaSE.com.Thread.JUC.LockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * void parkNanos(long nanos)：与park()类似，如果调用park方法的线程拿到了LockSupport关联的许可证，则调用LockSupport.parkNanos时会马上返回。
 * 不同的是，如果没有拿到许可证，则调用线程会被挂起nanos时间后自动返回。找个nanos是相对时间，相对现在时间的累加。
 */
public class LockSupport4 {
    public static void main(String[] args) throws InterruptedException {
        // 等待2秒后返回
        LockSupport.parkNanos(2000_000_000);
    }
}
