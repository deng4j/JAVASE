package JavaSE.com.GOF.memento;

/**
 * 源发器类
 */
public class Emp {
    private String ename;
    private int age;
    private double salary;

    /**
     * 进行备忘录操作，并返回备忘录对象
     */

    public EmpMemento memento(){
        return new EmpMemento(this);
    }

    /**
     * 数据恢复
     */
    public void recovery(EmpMemento mmt){
        this.ename=mmt.getEname();
        this.age=mmt.getAge();
        this.salary=mmt.getSalary();
    }


    public Emp(String ename, int age, double salary) {
        this.ename = ename;
        this.age = age;
        this.salary = salary;
    }

    public Emp() {
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
