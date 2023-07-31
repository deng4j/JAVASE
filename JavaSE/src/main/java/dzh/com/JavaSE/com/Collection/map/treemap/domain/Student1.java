package dzh.com.JavaSE.com.Collection.map.treemap.domain;

public class Student1{
    private String naem;
    private int age;

    public Student1(String naem, int age) {
        this.naem = naem;
        this.age = age;
    }

    public Student1() {
    }

    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "naem='" + naem + '\'' +
                ", age=" + age +
                '}';
    }
}
