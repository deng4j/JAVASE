package dzh.com.JavaSE.com.characteristic.Lambda.utils;

import java.io.Serializable;

@FunctionalInterface
public interface SFunction<T> extends Serializable {
    Object get(T source);
}