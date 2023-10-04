package dzh.com.JavaSE.com.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicLong;

/**
 * long objectFieldOffset(Field fied):返回指定变量所属类中的内存偏移地址，
 * 该偏移地址仅在该Unsafe函数中访问指定字段时使用。
 *
 * int arrayBaseOffset(Class arrayClass)：获取数组中第1个元素的地址
 * int arrayIndexScale(Class arrayClass)：获取数组中第一个元素占用的字节。
 *
 * boolean compareAndSwapLong(Object obj, long offset, long expect, long update)：比较对象obj中
 *  偏移量为offset的变量值释放与expect相等，相等则使用update值更新，返回true，否则返回false。
 *
 * public native long getLongvolatile(Object obj, long offset)：获取对象obj中偏移量为offset的变量对应volatile语义的值。
 *
 * void putLongvolatile(Object obj, long offset, long value)：设置obj对象中offset偏移的类型为long的field的值为value，
 *  支持volatile语义。
 *
 * void putOrderedLong(Object obj, long offset, long value)：设置obj对象中offset偏移地址对应long型field的值为value。
 *  不保证其他线程立即可见。只有变量使用volatile修饰并且预计会被意外修改时才使用该方法。
 *
 * void park(boolean isAbsolute, long time)：阻塞当前线程。
 *  isAbsolute为false，且time为0表示一直阻塞。time大于0表示等待指定时间后唤醒，这个time时相对值，单位ns，是个增量值，也就是相对当前时间累加time后唤醒。
 *  isAbsolute为true，且time大于0，表示等待指定时间后唤醒，这个time时绝对值，某个时间点换算为ms的值。
 *  另外，当其他线程调用了当前阻塞线程的interrupt方法而中断了当前线程时，线程会返回，而当其他线程调用了unPark方法，且把当前线程作为参数时，也会返回。
 *
 * void unpark(Object thread)：唤醒调用park后阻塞的线程。
 */
public class Unsafe1 {

    private String val;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        /**
         * JDK不允许正规渠道使用Unsafe类。
         * Unsafe.getUnsafe()方法会判断当前类是不是Bootstrap类加载器的localClass，
         * 很显然本Unsafe1时AppClassLoader加载的，所以会抛异常。
         *
         * 只能用发射来创建实例了。
         */

        Field field = Unsafe.class.getDeclaredField("theUnsafe");

        field.setAccessible(true);

        Unsafe unsafe = (Unsafe) field.get(null);

        // 获取val在Unsafe1中的偏移量
        long fieldOffset = unsafe.objectFieldOffset(Unsafe1.class.getDeclaredField("val"));
        System.out.println(fieldOffset);
    }
}
