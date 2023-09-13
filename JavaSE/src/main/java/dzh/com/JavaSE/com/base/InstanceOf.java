package dzh.com.JavaSE.com.base;

/**
 * instanceof 运算符用于测试对象是否是指定类型（类或子类或接口）的实例。
 */
public class InstanceOf {
    public static void main(String[] args) {
        // Object是所有对象的父类，子类的对象也是父类的一种类型。
        System.out.println(new InstanceOf() instanceof Object);
        System.out.println((Object)(new InstanceOf()) instanceof InstanceOf);

        // 父类不是子类的一种。所以不能将，父类实例强转成子类
        System.out.println(new Object() instanceof InstanceOf);
    }
}
