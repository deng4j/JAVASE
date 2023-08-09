package dzh.com.DesignPattern.DesignPattern.Factory.MethodFactory.factory;

import dzh.com.DesignPattern.DesignPattern.Factory.MethodFactory.domain.Audi;
import dzh.com.DesignPattern.DesignPattern.Factory.MethodFactory.domain.Car;

public class AudiFactory implements CarFactory{
    @Override
    public Car creatCar() {
        return new Audi();
    }
}
