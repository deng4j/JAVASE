package dzh.com.JavaSE.com.Collection.set.hashset.domain;

public class Student3 {
    private String name;
    private int age;

    public Student3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student3() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "姓名："+this.name+" "+"年龄："+this.age+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Student3 student = (Student3)o;

        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
