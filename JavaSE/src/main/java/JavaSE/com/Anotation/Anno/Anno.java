package JavaSE.com.Anotation.Anno;

import java.lang.annotation.*;

/**
 * 表示使用该注解的元素应被javadoc或类似工具文档化，它应用于类型声明，类型声明的注解会影响客户端对注解元素的使用。
 * 如果一个类型声明添加了Documented注解，那么它的注解会成为被注解元素的公共API的一部分。
 */
@Documented
//指定注解使用位置
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
//指定生命周期
@Retention(RetentionPolicy.RUNTIME)
//该注解可以被继承
@Inherited
public @interface Anno {
}
