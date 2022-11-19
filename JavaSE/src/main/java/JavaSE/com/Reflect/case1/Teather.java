package JavaSE.com.Reflect.case1;

public class Teather {
    private String name;
    private  int age;

    public Teather() {
    }

    public Teather(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void work(){
        System.out.println("改作业，写教案");
    }

    private String work( String work){
        return work;
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
}
