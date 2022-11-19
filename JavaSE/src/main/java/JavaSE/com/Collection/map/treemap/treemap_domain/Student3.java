package JavaSE.com.Collection.map.treemap.treemap_domain;

public class Student3 {
    private String naem;
    private int age;

    public Student3(String naem, int age) {
        this.naem = naem;
        this.age = age;
    }

    public Student3() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student3 student3 = (Student3) o;

        if (age != student3.age) return false;
        return naem != null ? naem.equals(student3.naem) : student3.naem == null;
    }

    @Override
    public int hashCode() {
        int result = naem != null ? naem.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Student3{" +
                "naem='" + naem + '\'' +
                ", age=" + age +
                '}';
    }
}
