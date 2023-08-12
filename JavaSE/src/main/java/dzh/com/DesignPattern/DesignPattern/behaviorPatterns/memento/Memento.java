package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.memento;

/**
 * Memento（备忘录)：存储原发器的内部状态，根据原发器来决定保存哪些内部状态。备忘录的设计一般可以参考原发器的设计，根据实际需要确定备忘录类中的属性。
 * 需要注意的是，除了原发器本身与负责人类之外，备忘录对象不能直接供其他类使用，原发器的设计在不同 的编程语言中实现机制会有所不同。
 */
public class Memento {
    private String ename;
    private int age;
    private double salary;

    public Memento(Originator e){
        this.ename=e.getEname();
        this.age=e.getAge();
        this.salary=e.getSalary();
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
