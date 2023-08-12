package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.mediator.mediator1.mediator;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.mediator.mediator1.department.Department;

import java.util.HashMap;

/**
 *  ConcreteMediator（具体中介者）：它是抽象中介者的子类，通过协调各个同事对象来实现 协作行为，它维持了对各个同事对象的引用。
 */
public class President implements Mediator {
    private HashMap<String, Department> map=new HashMap<>();

    @Override
    public void register(String dname, Department department) {
        map.put(dname,department);
    }

    @Override
    public void commend(String dname) {
        map.get(dname).selfAction();
    }
}
