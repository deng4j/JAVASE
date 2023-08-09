package dzh.com.JavaSE.com.characteristic.interfaces.People1;

public class Student extends People{
    @Override
    public void hand() {
        System.out.println("手臂正常活动");
    }

    public static void main(String[] args) {
        new Student();
    }
}
