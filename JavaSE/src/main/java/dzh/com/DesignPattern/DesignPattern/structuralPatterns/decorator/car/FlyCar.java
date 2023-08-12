package dzh.com.DesignPattern.DesignPattern.structuralPatterns.decorator.car;

/**
 * 具体装饰角色
 */
class FlyCar extends SuperCar{

    public FlyCar(ICar car) {
        super(car);
    }

    public void fly(){
        System.out.println("在天上飞");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}