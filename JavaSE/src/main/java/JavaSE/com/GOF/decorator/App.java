package JavaSE.com.GOF.decorator;

/**
 * 装饰模式：
 * 实现复合功能，降低系统耦合度，可以动态的增加或删除对象的职责，
 * 并使得需要装饰的具体构建类和具体装饰类可以独立变化，以便增加新的
 * 具体构建类和具体装饰类。
 *
 * 优点：1.拓展对象功能，比继承灵活，不会导致类个数急剧增加。
 * 2.可以对一个对象进行多次装饰，创造出不同行为的组合，使得功能
 * 更加强大。
 * 3.具体构建类和具体装饰类可以独立变化，用户可以根据需要自己增加
 * 新的具体构件子类和具体装饰子类。
 *
 * 缺点：1.产生很多小对象。
 * 2.容易出错，调试排查比较麻烦。
 */
public class App {
    public static void main(String[] args) {
        Car car=new Car();
        car.move();

        System.out.println("------增加飞行功能-------");
        FlyCar flyCar=new FlyCar(car);
        flyCar.move();
        System.out.println("------再增加游功能-------");
        WaterCar waterCar=new WaterCar(flyCar);
        waterCar.move();
    }
}
