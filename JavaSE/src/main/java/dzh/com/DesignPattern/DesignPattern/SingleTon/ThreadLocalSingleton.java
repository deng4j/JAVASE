package dzh.com.DesignPattern.DesignPattern.SingleTon;

/**
 * 线程局部变量：伪线程安全。
 * 在自己线程里是安全的。
 */
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
            ThreadLocal.withInitial(() -> new ThreadLocalSingleton());

    private ThreadLocalSingleton(){}

    public static ThreadLocalSingleton getInstance(){
        return threadLocalInstance.get();
    }

    public static void  remove(){
        threadLocalInstance.remove();
    }
}
