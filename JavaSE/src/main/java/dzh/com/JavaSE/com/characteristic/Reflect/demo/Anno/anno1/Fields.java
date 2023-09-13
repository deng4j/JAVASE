package dzh.com.JavaSE.com.characteristic.Reflect.demo.Anno.anno1;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.FIELD)
public @interface Fields {
    int sort() default 0 ;
    String value() ;
}
 