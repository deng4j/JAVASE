package JavaSE.com.Collection.set.treeset.tree_set_domain;

public class Student implements Comparable<Student>{
    private String name;
    private  int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }



    @Override
    public int compareTo(Student o) {
        return (this.age-o.age)==0?(this.name.compareTo(o.name)):(this.age-o.age);
    }

    @Override
    public String toString() {
        return "姓名："+this.name+" "+"年龄："+this.age+"\n";
    }
}
