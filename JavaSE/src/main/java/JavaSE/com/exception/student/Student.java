package JavaSE.com.exception.student;

public class Student {
    private  String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        if (age>=18&&age<=25){
            this.age = age;
        }else {
            try {
                throw  new Exception("年龄应该在18-25之间");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

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
        if (age>=18&&age<=25){
            this.age = age;
        }else {
            try {
                throw  new Exception("年龄应该在18-25之间");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "姓名："+this.name+" "+"年龄："+this.age+"\n";
    }
}
