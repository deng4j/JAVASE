package dzh.com.JavaSE.com.characteristic.interfaces.People;

/**
 * 接口中的成员方法默认是public  abstract的
 * 接口中的成员变量和类默认是public static final
 *
 * JDK 1.8以前，接口中的方法必须是public的
 * JDK 1.8时，接口中的方法可以是public的，也可以是default的
 * JDK 1.9时，接口中的方法可以是private的
 *
 * JDK1.8中为了加强接口的能力，使得接口可以存在具体的方法，前提是方法需要被default或static关键字所修饰。
 *
 * Java 8 新增了接口的默认方法。
 * default修饰的目的是让接口可以拥有具体的方法，让接口内部包含了一些默认的方法实现。
 * 被default修饰的方法是接口的默认方法。既只要实现该接口的类，都具有这么一个默认方法，默认方法也可以被重写。
 */
public interface Hand {
    // 手指数量
    int finger=10;

    // 经脉
    void skin();

    // 默认方法体
    default void defaultWork(){
        System.out.println("--defaultWork--");
        System.out.println("--手指数量"+finger+"--");
        blood();
    }
    private static void blood(){
        System.out.println("--血液流动--");
    }

    static void absorb(){
        System.out.println("--吸收天地精华--");
    }
}