package dzh.com.JavaSE.com.characteristic.Reflect.demo.genericsClass.demo1;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * public Type getGenericSuperclass()：用来返回表示当前Class 所表示的实体（类、接口、基本类型或 void）的直接超类的Type。
 * 如果这个直接超类是参数化类型的，则返回的Type对象必须明确反映在源代码中声明时使用的类型。
 *
 * public Type[] getGenericInterfaces()：与上面那个方法类似，只不过Java的类可以实现多个接口
 */

/**
 * 在编译期间确定父类的类型，是很有用的一种泛型编程手段
 */
public class T1 extends T2<Integer>{
    public static void main(String[] args) {  
        T1 t1 =new T1();
        System.out.println(t1.getType());
    }  
}

abstract class T2<T> {
    public String getType(){
        Type type = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return type.getTypeName();
    }
}