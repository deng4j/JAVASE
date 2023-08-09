package dzh.com.JavaSE.com.characteristic.Static_;

public class Farther {
    public static int id = 1;
    public static String name = "farther";

    public static void show(){
        System.out.println("farther");
    }

    public static void show1(){
        System.out.println("farther show1");
    }
}

class Child extends Farther{
    public static String name = "child";

    /**
     * 重写静态类，也必须是静态的
     */
    public static void show(){
        System.out.println("child");
    }

    public static void main(String[] args) {
        // 重写静态属性
        System.out.println(Farther.name==Child.name);
        // 继承静态属性
        System.out.println(Farther.id==Child.id);

        Farther.show();
        Child.show();

        Child.show1();
    }
}
