package JavaSE.com.Collection.list.arraylist.domain;

public class Student2 {
    private String name;
    private int age;
    private int score;

    public Student2(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "性别："+this.name+" "+"年龄："+this.age+" "+"成绩："+this.score+"\n";
    }
}
