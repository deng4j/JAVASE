package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.strategy;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.strategy.strategy.NewCustomerFewStrategy;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.strategy.strategy.OldCustomerManyStrategy;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.strategy.strategy.Strategy;

/**
 * 策略模式的主要目的是将算法的定义与使用分开，也就是将算法的行为和环境分开，将算法的定义放在专门的策略类中，每一个策略类封装了一种实现算法，
 * 使用算法的环境类针对抽 象策略类进行编程，符合“依赖倒转原则”。在出现新的算法时，只需要增加一个新的实现了抽 象策略类的具体策略类即可。
 *
 * 主要优点：
 *  1.策略模式提供了对“开闭原则”的完美支持，用户可以在不修改原有系统的基础上选择算法或行为，也可以灵活地增加新的算法或行为。
 *  2.策略模式提供了管理相关的算法族的办法。策略类的等级结构定义了一个算法或行为族， 恰当使用继承可以把公共的代码移到抽象策略类中，从而避免重复的代码。
 *  3.策略模式提供了一种可以替换继承关系的办法。如果不使用策略模式，那么使用算法的环境类就可能会有一些子类，每一个子类提供一种不同的算法。
 *    但是，这样一来算法的使用就 和算法本身混在一起，不符合“单一职责原则”，决定使用哪一种算法的逻辑和该算法本身混合 在一起，从而不可能再独立演化；而且使用继承无法实现算法或行为在程序运行时的动态切换。
 *  4.使用策略模式可以避免多重条件选择语句。多重条件选择语句不易维护，它把采取哪一种算法或行为的逻辑与算法或行为本身的实现逻辑混合在一起，将它们全部硬编码(Hard Coding) 在一个庞大的多重条件选择语句中，
 *    比直接继承环境类的办法还要原始和落后。
 *  5.策略模式提供了一种算法的复用机制，由于将算法单独提取出来封装在策略类中，因此不 同的环境类可以方便地复用这些策略类。
 *
 * 主要缺点:
 *  1.客户端必须知道所有的策略类，并自行决定使用哪一个策略类。这就意味着客户端必须理解这些算法的区别，以便适时选择恰当的算法。换言之，策略模式只适用于客户端知道所有 的算法或行为的情况。
 *  2.策略模式将造成系统产生很多具体策略类，任何细小的变化都将导致系统要增加一个新的具体策略类。
 *  3.无法同时在客户端使用多个策略类，也就是说，在使用策略模式时，客户端每次只能使用一个策略类，不支持使用一个策略类完成部分功能后再使用另一个策略类来完成剩余功能的情况。
 *
 * 适用场景：
 *  1.一个系统需要动态地在几种算法中选择一种，那么可以将这些算法封装到一个个的具体算法类中，而这些具体算法类都是一个抽象算法类的子类。
 *    换言之，这些具体算法类均有统一的接口，根据“里氏代换原则”和面向对象的多态性，客户端可以选择使用任何一个具体算法 类，并只需要维持一个数据类型是抽象算法类的对象。
 *  2.一个对象有很多的行为，如果不用恰当的模式，这些行为就只好使用多重条件选择语句来 实现。此时，使用策略模式，
 *    把这些行为转移到相应的具体策略类里面，就可以避免使用难 以维护的多重条件选择语句。
 *  3.不希望客户端知道复杂的、与算法相关的数据结构，在具体策略类中封装算法与相关的数 据结构，可以提高算法的保密性与安全性。
 *
 */
public class App {
    public static void main(String[] args) {
        Context context=new Context();

        Strategy s1=new OldCustomerManyStrategy();
        context.setStrategy(s1);
        context.pringPrice(1000);

        Strategy s2 = new NewCustomerFewStrategy();
        context.setStrategy(s2);
        context.pringPrice(1000);
    }
}
