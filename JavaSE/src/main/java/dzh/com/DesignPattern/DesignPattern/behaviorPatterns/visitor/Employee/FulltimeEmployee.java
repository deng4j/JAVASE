package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.visitor.Employee;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.visitor.Department.Department;

/**
 * 全职员工类：具体元素类
 *
 * ConcreteElement（具体元素）：具体元素实现了accept()方法，在accept()方法中调用访问者 的访问方法以便完成对一个元素的操作。
 */
public class FulltimeEmployee implements Employee {
    private String name;
    private double weeklyWage;
    private int workTime;

    public FulltimeEmployee(String name, double weeklyWage, int workTime) {
        this.name = name;
        this.weeklyWage = weeklyWage;
        this.workTime = workTime;
    }

    @Override
    public void accept(Department handler) {
        handler.visit(this); //调用访问者的访问方法
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeeklyWage(double weeklyWage) {
        this.weeklyWage = weeklyWage;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    public String getName() {
        return (this.name);
    }

    public double getWeeklyWage() {
        return (this.weeklyWage);
    }

    public int getWorkTime() {
        return (this.workTime);
    }
}