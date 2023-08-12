package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.visitor.Department;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.visitor.Employee.FulltimeEmployee;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.visitor.Employee.ParttimeEmployee;

/**
 * 财务部类：具体访问者类
 *
 * ConcreteVisitor（具体访问者）：具体访问者实现了每个由抽象访问者声明的操作，每一个操作用于访问对象结构中一种类型的元素。
 */
public class FADepartment extends Department {

    //实现财务部对全职员工的访问
    @Override
    public void visit(FulltimeEmployee employee) {
        int workTime = employee.getWorkTime();
        double weekWage = employee.getWeeklyWage();
        if (workTime > 40) {
            weekWage = weekWage + (workTime - 40) * 100;
        } else if (workTime < 40) {
            weekWage = weekWage - (40 - workTime) * 80;
            if (weekWage < 0) {
                weekWage = 0;
            }
        }
        System.out.println("正式员工" + employee.getName() + "实际工资为：" + weekWage + "元。");
    }

    //实现财务部对兼职员工的访问
    @Override
    public void visit(ParttimeEmployee employee) {
        int workTime = employee.getWorkTime();
        double hourWage = employee.getHourWage();
        System.out.println("临时工" + employee.getName() + "实际工资为：" + workTime * hourWage + "元。");
    }
}