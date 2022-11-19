package JavaSE.com.Reflect.reflect1;

public class Student {
    private String name;
    private String id="12331313231";
    public int age=18;

    public Student() {
        this.name="张三";
    }

    public void work(){
        System.out.println(name+"在学习");
    }
    private String eat(){
        return "炸鸡啤酒";
    }
    private String eat(String food){
        return food;
    }

    private Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}
