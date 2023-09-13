package dzh.com.JavaSE.com.characteristic.Reflect.demo.genericsClass.demo4;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * https://developer.aliyun.com/article/1226646?utm_content=g_1000372882
 *
 * 为什么仅仅一个匿名类的实例就可以产生这么巨大的差别？还可以在类型擦除的框架下完成泛型类型的获取？其中的原理是什么？
 * 其实它利用了JSR1414中，对类中的泛型信息，保存到类签名（Signature）的一个技巧。
 *
 * 首先，Java的编译器将泛型信息写入到ClassFile的Signature属性中。然后通过JRE的反射接口解析Signature中的字符串。最终“扒”出被隐藏的运行时类型信息。
 */
public class A<T> {

    public static <T> Type getGenericRuntimeType(A<T> a) {
        Type type = a.getClass().getGenericSuperclass();
        if (type == null) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type[] types = ((ParameterizedType)type).getActualTypeArguments();
            return types[0];
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getGenericRuntimeType(new A<String>()));
        System.out.println(getGenericRuntimeType(new A<String>() {}).getTypeName());
    }
}
