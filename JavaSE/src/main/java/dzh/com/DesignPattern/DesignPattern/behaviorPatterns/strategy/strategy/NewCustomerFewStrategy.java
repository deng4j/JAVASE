package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.strategy.strategy;

/**
 * 算法族：
 * 普通客户小批量
 *
 * ConcreteStrategy（具体策略类）：它实现了在抽象策略类中声明的算法，在运行时，具体策略类将覆盖在环境类中定义的抽象策略类对象，使用一种具体的算法实现某个业务处理。
 */
public class NewCustomerFewStrategy implements Strategy {
    @Override
    public double getprice(double standarPrice) {
        System.out.println("不打折");
        return standarPrice;
    }
}






