package JavaSE.com.JDBC.jdbc;

import java.util.Date;
/**
 * 实体类使用包装数据类型，包装类型默认是null
 */
public class Employee {
    private Integer eid;
    private String ename;
    private Integer sid;
    private Integer salary;
    private Date joinDate;
    private Double bonus;

    public Employee() {
    }

    public Employee(int eid, String ename, int sid, int salary, Date joinDate, double bonus) {
        this.eid = eid;
        this.ename = ename;
        this.sid = sid;
        this.salary = salary;
        this.joinDate = joinDate;
        this.bonus = bonus;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", sid=" + sid +
                ", salary=" + salary +
                ", joinDate=" + joinDate +
                ", bonus=" + bonus +
                '}';
    }
}
