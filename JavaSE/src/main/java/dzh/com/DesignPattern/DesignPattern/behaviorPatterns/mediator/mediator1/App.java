package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.mediator.mediator1;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.mediator.mediator1.department.Department;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.mediator.mediator1.department.Development;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.mediator.mediator1.department.Finacial;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.mediator.mediator1.department.Market;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.mediator.mediator1.mediator.Mediator;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.mediator.mediator1.mediator.President;

/**
 * 中介模式：解耦多个同事对象之间的交互关系。每个对象都持有中介者对象的引用，
 * 只跟中介者对象打交道。通过中介者对象统一管理这些交互关系。
 *
 * 优点:
 *  1.中介者模式简化了对象之间的交互，它用中介者和同事的一对多交互代替了原来同事之间的多对多交互，一对多关系更容易理解、维护和扩展，将原本难以理解的网状结构转换成相对简单的星型结构。
 *  2.中介者模式可将各同事对象解耦。中介者有利于各同事之间的松耦合，我们可以独立的改变和复用每一个同事和中介者，增加新的中介者和新的同事类都比较方便，更好地符合“开闭 原则”。
 *  3.可以减少子类生成，中介者将原本分布于多个对象间的行为集中在一起，改变这些行为只 需生成新的中介者子类即可，这使各个同事类可被重用，无须对同事类进行扩展。
 *
 * 缺点:在具体中介者类中包含了大量同事之间的交互细节，可能会导致具体中介者类非常复杂，使 得系统难以维护。
 *
 * 适用场景:
 *  1.系统中对象之间存在复杂的引用关系，系统结构混乱且难以理解。
 *  2.一个对象由于引用了其他很多对象并且直接和这些对象通信，导致难以复用该对象。
 *  3.想通过一个中间类来封装多个类中的行为，而又不想生成太多的子类。可以通过引入中介 者类来实现，在中介者中定义对象交互的公共行为，如果需要改变行为则可以增加新的具体中介者类。
 */
public class App {
    public static void main(String[] args) {
        Mediator president=new President();

        // 注册
        Department market=new Market(president);
        Department development=new Development(president);
        Department finacial=new Finacial(president);

        market.selfAction();
        market.outAction();
        System.out.println("----------------");

        development.selfAction();
        development.outAction();
        System.out.println("----------------");
        finacial.selfAction();
        finacial.outAction();
    }
}
