package dzh.com.DesignPattern.DesignPattern.createPatterns.Factory.StaticFactory.CarFactory;

import dzh.com.DesignPattern.DesignPattern.createPatterns.Factory.StaticFactory.CarFactory.domain.Car;

/**
 * 静态工厂模式就是帮你new各种对象，而不是通过构造器。
 *
 * 静态工厂方法比构造器优势：
 *  1.静态工厂方法有名字。而构造器没有名字，多个不同的构造方法只能通过参数的差异来判断，非常不好。
 *  2.静态工厂方法可以选择不必每次调用都创建一个新的对象。
 *  3.静态工厂方法可以返回原返回类型的子类。
 *  4.静态工厂方法在创建参数化类型实例时，代码更简洁。
 * 缺点：
 *  1.类如果不含有共有或受保护的构造器，就不能被子类化。
 *  2.与其他静态方法实际上没有任何区别。
 *
 * 静态工厂的一些命名：
 *  valueOf / of：不太严格地讲，该方法返回实例与它的参数具有相同的值，代表类型转换。
 *  getInstance：返回的实例时通过方法的参数描述的，但是不能够说与参数具有相同的值。
 *  newInstance：保证返回的每个实例都与其他实例不同。
 *  getType：返回对象的类型。
 *  newType：返回的对象类型。
 */
public class TestApp {
    public static void main(String[] args) {
        try {
            Car beaz = CarFactory.creatCar("benz");
            Car audi = CarFactory.creatCar("Audi");
            beaz.run();
            audi.run();
        } catch (ClassNotFoundException e) {
            System.out.println("没有这个汽车模型");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
