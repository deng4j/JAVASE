package JavaSE.com.GOF.SingleTon;

import java.io.ObjectStreamException;

/**
 * 懒汉式(延迟加载)
 * 资源利用率高，并发效率低，调用效率低。
 * 可以缩小同步代码块范围提高效率
 *
 * 懒汉式线程不安全，要加锁。因为，多个可能线程在
 * 判断语句中失去执行权，多个线程判断lazyTon==null，从而
 * 创建新的对象。
 */
public class LazyTon {
    public static volatile LazyTon lazyTon;

    private LazyTon(){};

    public  static LazyTon getLazyTon(){
        //如果对象已经创建，不用竞争锁
        if (null==lazyTon){
            synchronized (LazyTon.class){
                if (lazyTon==null){
                    lazyTon=new LazyTon();
                }
            }
        }

        return lazyTon;
    }
    /**
     * 反序列化时，如果定义了readResolve()则直接返回方法指定对象。而不需要单独
     * 再创建对象
     *
     */
    private Object readResolve() throws ObjectStreamException{
        return lazyTon;
    }
}
