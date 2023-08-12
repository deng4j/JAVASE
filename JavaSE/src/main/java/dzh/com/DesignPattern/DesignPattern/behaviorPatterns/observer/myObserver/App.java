package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.observer.myObserver;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.observer.myObserver.observer.ObserverA;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.observer.myObserver.subject.ConcreteSubject;

/**
 * 观察者模式(Observer Pattern)：定义对象之间的一种一对多依赖关系， 使得每当一个对象状态发生改变时，其相关依赖对象皆得到通知并被自动更新。
 *
 * 优点:
 *  1.观察者模式可以实现表示层和数据逻辑层的分离，定义了稳定的消息更新传递机制，并抽 象了更新接口，使得可以有各种各样不同的表示层充当具体观察者角色。
 *  2.观察者模式在观察目标和观察者之间建立一个抽象的耦合。观察目标只需要维持一个抽象观察者的集合，无须了解其具体观察者。由于观察目标和观察者没有紧密地耦合在一起，因此它们可以属于不同的抽象化层次。
 *  3.观察者模式支持广播通信，观察目标会向所有已注册的观察者对象发送通知，简化了一对多系统设计的难度。
 *  4.观察者模式满足“开闭原则”的要求，增加新的具体观察者无须修改原有系统代码，在具体 观察者与观察目标之间不存在关联关系的情况下，增加新的观察目标也很方便。
 *
 * 缺点:
 *  1.如果一个观察目标对象有很多直接和间接观察者，将所有的观察者都通知到会花费很多时间。
 *  2.如果在观察者和观察目标之间存在循环依赖，观察目标会触发它们之间进行循环调用，可能导致系统崩溃。
 *  3.观察者模式没有相应的机制让观察者知道所观察的目标对象是怎么发生变化的，而仅仅只是知道观察目标发生了变化。
 *
 * 适用场景：
 *  1.一个抽象模型有两个方面，其中一个方面依赖于另一个方面，将这两个方面封装在独立的 对象中使它们可以各自独立地改变和复用。
 *  2. 一个对象的改变将导致一个或多个其他对象也发生改变，而并不知道具体有多少对象将发 生改变，也不知道这些对象是谁。
 *  3.需要在系统中创建一个触发链，A对象的行为将影响B对象，B对象的行为将影响C对 象……，可以使用观察者模式创建一种链式触发机制。
 */
public class App {
    public static void main(String[] args) {
        //创建目标对象
        ConcreteSubject subject=new ConcreteSubject();
        //创建三个观察者对象
        ObserverA obs1=new ObserverA();
        ObserverA obs2=new ObserverA();
        ObserverA obs3=new ObserverA();

        //将这三个观察者添加到subject对象的观察者队伍中
        subject.registerObserver(obs1);
        subject.registerObserver(obs2);
        subject.registerObserver(obs3);

        //改变subject的状态
        subject.setState(3000);

        //查看观察者状态是不是也改变了
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());

    }
}
