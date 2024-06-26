package dzh.com.JavaSE.com.characteristic.interfaces;

/**
 * 从Java8开始，明确提出了函数式接口的概念，并且为这类接口用专门的@FunctionalInterface 注解来标识。
 *
 * 函数式接口，当然首先是一个接口，然后就是在这个接口里面可以包含以下内容：
 *  1.只能有一个抽象方法。
 *  2.可以有多个静态方法和默认方法。
 *  3.默认包含Object类的方法。
 *
 * 标记接口：是没有包含方法声明的接口，用来表明某个类实现了具有某种属性的接口，如Serializable接口。
 */
@FunctionalInterface
public interface FuncInterface {

    void show();

    public static void main(String[] args) {
        FuncInterface f = () -> System.out.println("show");
        f.show();
    }
}
