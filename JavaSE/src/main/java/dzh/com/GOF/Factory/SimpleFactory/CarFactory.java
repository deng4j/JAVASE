package dzh.com.GOF.Factory.SimpleFactory;

/**
 * 简单工厂模式就是帮你new各种对象，也叫静态工厂。
 * 缺点：对新功能不修改是无法拓展的。
 * 原则：
 * 开闭原则：要对功能进行拓展的时候，禁止对原代码进行修改，应该增加对象
 * 依赖倒置原则：要针对接口编程，不要针对实现编程
 * 迪米特法则：只与你直接的朋友通信，避免和陌生人通信
 */
public class CarFactory {
    private CarFactory(){}

    public static Car creatCar(String car) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("dzh.com.GOF.Factory.SimpleFactory." + car);
        Car obj = (Car) aClass.newInstance();
        if (obj instanceof Car){
            return obj;
        }else {
            return null;
        }
    }
}
