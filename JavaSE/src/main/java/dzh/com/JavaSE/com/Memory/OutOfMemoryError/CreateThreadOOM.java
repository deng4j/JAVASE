package dzh.com.JavaSE.com.Memory.OutOfMemoryError;

/**
 * -Xss2M
 * 设置栈内存2M
 * <p>
 * 测试为每个线程分配大的栈内存，导致可创建的线程数减少，导致OOM，这很危险，会导致死机。
 */
public class CreateThreadOOM {
    
    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    private static void dontStop() {
        while (true) ;
    }

    public static void main(String[] args) {
        CreateThreadOOM sof = new CreateThreadOOM();
        try {
            sof.stackLeakByThread();
        } catch (Error e) {
            throw e;
        }
    }
}
