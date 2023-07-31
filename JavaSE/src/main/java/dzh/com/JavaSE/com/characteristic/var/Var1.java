package dzh.com.JavaSE.com.characteristic.var;

/**
 * Java中var是Java10版本新出的特性，用它来定义局部变量。
 * var是什么：
 *  1.var不是关键字，它相当于是一种动态类型；
 *  2.var动态类型是编译器根据变量所赋的值来推断类型；
 *  3.var 没有改变Java的本质，var只是一种简便的写法，
 *
 * 用var声明变量的注意事项：
 * 1.var只能在方法内定义变量，不允许定义类的成员变量。
 * 2.var 定义变量必须赋初始值。
 * 3.var每次只能定义一个变量，不能复合声明变量。
 *
 * 优缺点：
 *  优点：使代码简洁和整齐。
 *  缺点：降低了程序的可读性。
 */
public class Var1 {

    public static void main(String[] args) {
        m1();
    }

    private static void m1() {
        var varStr = "varString1";
        varStr = "varString2";
        System.out.println(varStr);
    }
}
