package dzh.com.DesignPattern.DesignPattern.SingleTon;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 饿汉式单例模式：
 *
 * 类初始化时立刻加载这个对象（没有延迟优势）。类加载天然是线程安全的；
 * 没有同步锁，调用效率高
 *
 * 可以通过反射和反序列化破解。
 * 所以谨慎使用Serializable接口，或者使用transient关键字
 */
public class HungryTon{
    public static HungryTon hungryTon=new HungryTon();
    private HungryTon(){};

    public static HungryTon getHungryTon(){
        return hungryTon;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        HungryTon hungryTon1=HungryTon.getHungryTon();
        HungryTon hungryTon2=HungryTon.getHungryTon();
        System.out.println(hungryTon1==hungryTon2);

        //通过反射破解
        Class<?> aClass = Class.forName("dzh.com.DesignPattern.DesignPattern.SingleTon.HungryTon");
        Constructor<?> Cons = aClass.getDeclaredConstructor(null);
        Cons.setAccessible(true);
        HungryTon H1 = (HungryTon) Cons.newInstance();
        HungryTon H2 = (HungryTon) Cons.newInstance();
        System.out.println(H1==H2);
    }
}
