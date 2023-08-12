package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.memento;

/**
 * Originator（原发器）：它是一个普通类，可以创建一个备忘录，并存储它的当前内部状态，也可以使用备忘录来恢复其内部状态，
 * 一般将需要保存内部状态的类设计为原发器。
 */
public class Originator {
    private String ename;
    private int age;
    private double salary;

    /**
     * 进行备忘录操作，并返回备忘录对象
     */

    public Memento memento(){
        return new Memento(this);
    }

    /**
     * 数据恢复
     */
    public void recovery(Memento mmt){
        this.ename=mmt.getEname();
        this.age=mmt.getAge();
        this.salary=mmt.getSalary();
    }


    public Originator(String ename, int age, double salary) {
        this.ename = ename;
        this.age = age;
        this.salary = salary;
    }

    public Originator() {
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

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
