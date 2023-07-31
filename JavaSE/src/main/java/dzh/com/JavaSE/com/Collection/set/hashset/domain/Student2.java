package dzh.com.JavaSE.com.Collection.set.hashset.domain;

import java.util.Date;

public class Student2 {
    private String name;
    private int age;
    private Date date;

    public Student2(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public Student2() {
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

    public Date getScore() {
        return date;
    }

    public void setScore(int score) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "姓名："+this.name+" "+"年龄："+this.age+""+"分数:"+this.date+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Student2 student = (Student2)o;

        if (name != null ? !name.equals(student.name) : student.name != null) {
            return false;
        }
        return date != null ? date.equals(student.date) : student.date == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
