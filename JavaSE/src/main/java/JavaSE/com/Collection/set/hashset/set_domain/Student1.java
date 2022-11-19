package JavaSE.com.Collection.set.hashset.set_domain;

public class Student1 {
    private String name;
    private int age;
    private int score;

    public Student1(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Student1() {
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "姓名："+this.name+" "+"年龄："+this.age+""+"分数:"+this.score+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student1 student = (Student1) o;

        if (age != student.age) return false;
        if (score != student.score) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + score;
        return result;
    }



}
