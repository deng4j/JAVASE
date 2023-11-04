package dzh.com.DesignPattern.DesignPattern.createPatterns.Factory.StaticFactory.CarFactory;

import dzh.com.DesignPattern.DesignPattern.createPatterns.Factory.StaticFactory.CarFactory.domain.Car;

public class CarFactory {
    /**
     * 设为私有化，防止实例化
     */
    private CarFactory(){}

    public static Car creatCar(String car) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("dzh.com.GOF.Factory.StaticFactory.CarFactory." + car);
        Car obj = (Car) aClass.newInstance();
        if (obj instanceof Car){
            return obj;
        }else {
            return null;
        }
    }
}
