package dzh.com.JavaSE.com.characteristic.Optional.domain;

import java.util.Optional;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public  String getStudentName()
    {
        Optional<String> optional = Optional.ofNullable(this).map(s -> s.getName());
        String str = optional.orElse("Unkown");
        return str;
    }

    public  void filterAge()
    {
        Optional.ofNullable(this).filter( u -> u.getAge() > 18).ifPresent(u ->  System.out.println("The student age is more than 18."));
    }
}