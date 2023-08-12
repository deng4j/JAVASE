package dzh.com.DesignPattern.DesignPattern.structuralPatterns.decorator.decorator1;

/**
 * ConcreteDecorator（具体装饰类）：它是抽象装饰类的子类，负责向构件添加新的职责。每一个具体装饰类都定义了一些新的行为，
 * 它可以调用在抽象装饰类中定义的方法，并可以增 加新的方法用以扩充对象的行为。
 */
class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {
        super(component);
    }

    public void operation() {
        super.operation(); //调用原有业务方法
        addedBehavior(); //调用新增业务方法
    }

    private void addedBehavior() {
        System.out.println("业务增强");
    }
}