package dzh.com.JavaSE.com.Collection.map.treemap.domain;

public class Student implements Comparable<Student>{
    private String naem;
    private int age;

    public Student(String naem, int age) {
        this.naem = naem;
        this.age = age;
    }

    public Student() {
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
        return "student{" +
                "naem='" + naem + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student s1) {
        return  s1.getAge()-this.getAge()==0?s1.getNaem().compareTo(this.getNaem()): s1.getAge()-this.getAge();
    }
}
