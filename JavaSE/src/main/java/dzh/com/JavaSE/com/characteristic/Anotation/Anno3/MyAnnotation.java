package dzh.com.JavaSE.com.characteristic.Anotation.Anno3;
import dzh.com.JavaSE.com.characteristic.enums.season.Season;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 通过反编译可知，注解的成员变量是一个个的抽象方法
 * 在定义注解时，不能继承其他的注解或接口。
 * 接口成员默认都是public abstract的
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    int a()default 0;

    String name()default "";

    Class clazz() default MyAnnotation.class;

    int[] arr()default {};

    //枚举数组
    Season[] seasons() default {Season.SPRING, Season.SUMMER};

    //value。后期我们在使用注解的时候，如果我们只需要给注解的value属性赋值。
    //那么value就可以省略
    String value();
}


