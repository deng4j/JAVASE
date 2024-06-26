package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.state;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.state.State.BookedState;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.state.State.FreeState;

/**
 * 状态模式(State Pattern)：允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它的类。
 * 其别名为状态对象(Objects for States)，状态模式是一种对象行为型模式。
 *
 * 优点:
 *  1.封装了状态的转换规则，在状态模式中可以将状态的转换代码封装在环境类或者具体状态 类中，可以对状态转换代码进行集中管理，而不是分散在一个个业务方法中。
 *  2.将所有与某个状态有关的行为放到一个类中，只需要注入一个不同的状态对象即可使环境 对象拥有不同的行为。
 *  3.允许状态转换逻辑与状态对象合成一体，而不是提供一个巨大的条件语句块，状态模式可 以让我们避免使用庞大的条件语句来将业务方法和状态转换代码交织在一起。
 *  4.可以让多个环境对象共享一个状态对象，从而减少系统中对象的个数。
 *
 * 缺点:
 *  1.状态模式的使用必然会增加系统中类和对象的个数，导致系统运行开销增大。
 *  2.状态模式的结构与实现都较为复杂，如果使用不当将导致程序结构和代码的混乱，增加系 统设计的难度。
 *  3.状态模式对“开闭原则”的支持并不太好，增加新的状态类需要修改那些负责状态转换的源 代码，否则无法转换到新增状态；而且修改某个状态类的行为也需修改对应类的源代码。
 *
 * 适用场景:
 *  1.对象的行为依赖于它的状态（如某些属性值），状态的改变将导致行为的变化。
 *  2.在代码中包含大量与对象状态有关的条件语句，这些条件语句的出现，会导致代码的可维 护性和灵活性变差，不能方便地增加和删除状态，并且导致客户类与类库之间的耦合增强。
 */
public class App {
    public static void main(String[] args) {
        Context ctx=new Context();

        ctx.setState(new FreeState());
        ctx.setState(new BookedState());
    }
}
