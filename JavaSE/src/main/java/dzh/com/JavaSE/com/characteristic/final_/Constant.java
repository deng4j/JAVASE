package dzh.com.JavaSE.com.characteristic.final_;

/**
 * 在类加载的准备阶段，如果类属性是一个常量，那么初始化时会去常量池找到该值，如何初始化。
 * 否则就是初始化为默认值。
 */
public class Constant {

    /**
     * 准备阶段初始化为0
     */
    public static int value = 123;

    /**
     * 准备阶段初始化为123
     */
    public static final int constantValue = 123;
}
