package dzh.com.DesignPattern.DesignPattern.structuralPatterns.decorator.car;

/**
 * 具体构件角色（真实对象）
 */
class Car implements ICar{

    @Override
    public void move() {
        System.out.println("在陆地上跑");
    }
}