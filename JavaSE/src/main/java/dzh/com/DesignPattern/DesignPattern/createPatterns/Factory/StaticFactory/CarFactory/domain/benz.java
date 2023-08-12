package dzh.com.DesignPattern.DesignPattern.createPatterns.Factory.StaticFactory.CarFactory.domain;

public class benz implements Car {
    @Override
    public void run() {
        System.out.println("我的奔驰在跑");
    }
}
