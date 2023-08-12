package dzh.com.DesignPattern.DesignPattern.createPatterns.Factory.MethodFactory.factory;

import dzh.com.DesignPattern.DesignPattern.createPatterns.Factory.MethodFactory.domain.Audi;
import dzh.com.DesignPattern.DesignPattern.createPatterns.Factory.MethodFactory.domain.Car;

public class AudiFactory implements CarFactory{
    @Override
    public Car creatCar() {
        return new Audi();
    }
}
