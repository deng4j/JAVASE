package JavaSE.com.Anotation.Anotation1;
import JavaSE.com.enums.season.Season;

/**
 * Demo class
 *通过反编译可知，注解的成员变量是一个个的抽象方法
 * @author keriezhang
 * @date 2016/10/31
 */

public @interface MyAnotation {
    int a()default 0;
    public String name()default "";
    public Class clazz() default MyAnotation.class;
    public int[] arr()default {};
    //枚举数组
    public Season[] seasons() default {Season.SPRING, Season.SUMMER};

    //value。后期我们在使用注解的时候，如果我们只需要给注解的value属性赋值。
    //那么value就可以省略
    public String value();

    //定义一个注解类型的属性
       // public MyAnotation anno() default @MyAnotation;


}


