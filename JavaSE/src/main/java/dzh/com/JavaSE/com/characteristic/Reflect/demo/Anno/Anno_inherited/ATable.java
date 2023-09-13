package dzh.com.JavaSE.com.characteristic.Reflect.demo.Anno.Anno_inherited;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ATable {
    public String name() default "";
}
