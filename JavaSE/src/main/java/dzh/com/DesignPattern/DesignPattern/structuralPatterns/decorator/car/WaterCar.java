package dzh.com.DesignPattern.DesignPattern.structuralPatterns.decorator.car;

/**
 * 具体装饰角色
 */
class WaterCar extends SuperCar{

    public WaterCar(ICar car) {
        super(car);
    }

    public void swim(){
        System.out.println("水上游");
    }

    @Override
    public void move() {
        super.move();
        swim();
    }
}