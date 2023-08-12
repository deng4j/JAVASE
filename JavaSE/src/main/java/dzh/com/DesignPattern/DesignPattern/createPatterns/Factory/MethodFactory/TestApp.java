package dzh.com.DesignPattern.DesignPattern.createPatterns.Factory.MethodFactory;

import dzh.com.DesignPattern.DesignPattern.createPatterns.Factory.MethodFactory.domain.Car;
import dzh.com.DesignPattern.DesignPattern.createPatterns.Factory.MethodFactory.factory.AudiFactory;

/**
 * 工厂方法模式：避免简单工厂模式的缺点，不完全满足OCP
 * 太复杂，不推荐
 * 需要什么车就创建什么车的工厂
 */
public class TestApp {
    public static void main(String[] args) {
        Car audi = new AudiFactory().creatCar();
        audi.run();
    }
}
