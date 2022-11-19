package JavaSE.com.Anotation.Anotation2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//注解的生命周期，元注解：描述注解的注解
@Retention(value = RetentionPolicy.RUNTIME)
public @interface test {
}
