package JavaSE.com.GOF.SingleTon;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 破解：单例依然可以通过反射和反序列化破解（枚举单例除外）
 * 反序列化取出后会创建新对象
 */
public class App {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        HungryTon hungryTon1=HungryTon.getHungryTon();
        HungryTon hungryTon2=HungryTon.getHungryTon();
        System.out.println(hungryTon1==hungryTon2);
        Reflect();


    }

    private static void Reflect() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //通过反射破解
        Class<?> aClass = Class.forName("JavaSE.com.GOF.SingleTon.HungryTon");
        Constructor<?> Cons = aClass.getDeclaredConstructor(null);
        Cons.setAccessible(true);
        HungryTon H1 = (HungryTon) Cons.newInstance();
        HungryTon H2 = (HungryTon) Cons.newInstance();
        System.out.println(H1==H2);
    }
}
