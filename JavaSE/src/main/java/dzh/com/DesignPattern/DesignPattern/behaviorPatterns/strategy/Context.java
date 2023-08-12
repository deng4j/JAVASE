package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.strategy;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.strategy.strategy.Strategy;

/**
 * Context（环境类）：环境类是使用算法的角色，它在解决某个问题（即实现某个方法）时可以采用多种策略。
 * 在环境类中维持一个对抽象策略类的引用实例，用于定义所采用的策略。
 */
public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void pringPrice(double s){
        System.out.println("您的报价："+strategy.getprice(s));
    }
}
