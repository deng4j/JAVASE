package JavaSE.com.StaticFinal;

/**
 * 1.如果final修饰的字段已经被初始化了，则不能通过反射去修改该字段。
 * 2.被final修饰的类不能被继承
 * 3.被final修饰的变量不能修改地址
 * 4.被final修饰的方法不能被重写
 * 5.被final修饰的参数不能修改
 * 5.类的private方法会隐式地被指定为final方法。
 * 6.当final变量是基本数据类型以及String类型时，如果在编译期间能知道它的确切值，则编译器会
 * 把它当做编译期常量使用。也就是说在用到该final变量的地方，相当于直接访问的这个常量，不需要在运行时确定。
 */
public class MyFinal {
    final String name = "Hollis";

}
