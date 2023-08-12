package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.mediator.mediator1.department;

/**
 *  Colleague（抽象同事类）：它定义各个同事类公有的方法，并声明了一些抽象方法来供子类 实现，同时它维持了一个对抽象中介者类的引用，其子类可以通过该引用来与中介者通信。
 */
public interface Department {
    /**
     * 做本部门的事情
     */
    void selfAction();
    /**
     * 向总经理发出申请
     */
    void outAction();
}
