package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.template;

/**
 * AbstractClass（抽象类）：在抽象类中定义了一系列基本操作(PrimitiveOperations)，这些基 本操作可以是具体的，也可以是抽象的，每一个基本操作对应算法的一个步骤，在其子类中可以重定义或实现这些步骤。
 * 同时，在抽象类中实现了一个模板方法(Template Method)，用于 定义一个算法的框架，模板方法不仅可以调用在抽象类中实现的基本方法，也可以调用在抽象类的子类中实现的基本方法，还可以调用其他对象中的方法。
 */
public abstract class BankTemplate {
    public void takeNumber(){
        System.out.println("排队取号");
    }

    /**
     * 钩子方法
     */
    abstract void transact();

    public void evaluate(){
        System.out.println("反馈评分");
    }

    public final void process(){
        this.takeNumber();
        this.transact();
        this.evaluate();

    }
}
