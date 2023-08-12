package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.visitor;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.visitor.Department.Department;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.visitor.Employee.Employee;

import java.util.ArrayList;

/**
 * 员工列表类：对象结构
 *
 * ObjectStructure（对象结构）：对象结构是一个元素的集合，它用于存放元素对象，并且提 供了遍历其内部元素的方法。它可以结合组合模式来实现，也可以是一个简单的集合对象， 如一个List对象或一个Set对象。
 */
public class EmployeeList {
    //定义一个集合用于存储员工对象
    private ArrayList<Employee> list = new ArrayList<Employee>();

    public void addEmployee(Employee employee) {
        list.add(employee);
    }

    //遍历访问员工集合中的每一个员工对象
    public void accept(Department handler) {
        for (Object obj : list) {
            ((Employee) obj).accept(handler);
        }
    }
}