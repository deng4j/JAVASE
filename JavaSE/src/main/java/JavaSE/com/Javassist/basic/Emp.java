package JavaSE.com.Javassist.basic;

public class Emp {
    private int empno;
    private String name;

    public Emp() {
    }

    public Emp(int empno, String name) {
        this.empno = empno;
        this.name = name;
    }

    public void work(String name) {
        this.name=name;
        System.out.println(this.name+"在工作");
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
