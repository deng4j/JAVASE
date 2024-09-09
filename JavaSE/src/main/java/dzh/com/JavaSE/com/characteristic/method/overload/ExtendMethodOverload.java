package dzh.com.JavaSE.com.characteristic.method.overload;

// 静态分派
public class ExtendMethodOverload {

    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        ExtendMethodOverload extendMethodOverload = new ExtendMethodOverload();
        extendMethodOverload.sayHello(man);
        extendMethodOverload.sayHello(woman);
    }
}
