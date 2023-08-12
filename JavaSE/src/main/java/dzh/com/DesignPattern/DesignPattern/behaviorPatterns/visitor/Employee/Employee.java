package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.visitor.Employee;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.visitor.Department.Department;

/**
 * 员工类：抽象元素类
 *
 * Element（抽象元素）：抽象元素一般是抽象类或者接口，它定义一个accept()方法，该方法通常以一个抽象访问者作为参数。
 */
public interface Employee {
    public void accept(Department handler); //接受一个抽象访问者访问
}