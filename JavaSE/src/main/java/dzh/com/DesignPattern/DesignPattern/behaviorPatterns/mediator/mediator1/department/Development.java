package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.mediator.mediator1.department;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.mediator.mediator1.mediator.Mediator;

/**
 * ConcreteColleague（具体同事类）：它是抽象同事类的子类；每一个同事对象在需要和其他同事对象通信时，先与中介者通信，通过中介者来间接完成与其他同事类的通信；
 * 在具体同事类中实现了在抽象同事类中声明的抽象方法。
 *
 * 研发部对象
 */
public class Development implements Department{
    /**
     * 持有中介者的引用
     */
    private Mediator m;

    public Development(Mediator m) {
        this.m = m;
        //相互可以找到
        m.register("development",this);
    }

    @Override
    public void selfAction() {
        System.out.println("研发部，开发项目");
    }

    @Override
    public void outAction() {
        System.out.println("汇报要求拨款");
    }
}
