package dzh.com.JavaSE.com.characteristic.method.overload;

import java.io.Serializable;

/**
 * 方法重载会不断找更合适的方法
 *
 * 'a'是一个char类型的数据，自然会寻找参数类型为char的重载方法，如果注释掉sayHello(char arg)方法，就会找sayHello(int arg)方法，因为'a'还能代表数字97。
 * 如果继续注释掉sayHello(int arg)方法，就会找sayHello(long arg)方法，'a'转型为整数97之后，进一步转型为长整数97L。
 * 如果继续注释掉sayHello(long arg)方法，就会找sayHello(Character arg)方法，因为'a'被包装为它的封装类型java.lang.Character，这时发生了一次自动装箱。
 */
public class Suitable {
    public static void sayHello(Object arg) {
        System.out.println("hello Object");
    }

    public static void sayHello(int arg) {
        System.out.println("hello int");
    }

    public static void sayHello(long arg) {
        System.out.println("hello long");
    }

    public static void sayHello(Character arg) {
        System.out.println("hello Character");
    }

    public static void sayHello(char arg) {
        System.out.println("hello char");
    }

    public static void sayHello(char... arg) {
        System.out.println("hello char ...");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("hello Serializable");
    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
