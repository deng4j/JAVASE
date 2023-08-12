package dzh.com.DesignPattern.DesignPattern.structuralPatterns.decorator.car;

/**
 * 装饰角色
 */
class SuperCar implements ICar{
    private ICar car;

    public SuperCar(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}