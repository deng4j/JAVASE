package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.template;

/**
 * ConcreteClass（具体子类）：它是抽象类的子类，用于实现在父类中声明的抽象基本操作以完成子类特定算法的步骤，也可以覆盖在父类中已经实现的具体基本操作。
 */
public class DrawMoney extends BankTemplate{

    @Override
    void transact() {
        System.out.println("我要取100w");
    }
}