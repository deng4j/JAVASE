package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.mediator.mediator1.mediator;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.mediator.mediator1.department.Department;

/**
 * Mediator（抽象中介者）：它定义一个接口，该接口用于与各同事对象之间进行通信。
 */
public interface Mediator {
    void register(String dname, Department department);
    void commend(String dname);
}
