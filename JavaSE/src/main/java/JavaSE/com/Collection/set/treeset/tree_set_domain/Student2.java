package JavaSE.com.Collection.set.treeset.tree_set_domain;

public class Student2 {
    private String name;
    private  int age;

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "姓名："+this.name+" "+"年龄："+this.age+"\n";
    }
}
