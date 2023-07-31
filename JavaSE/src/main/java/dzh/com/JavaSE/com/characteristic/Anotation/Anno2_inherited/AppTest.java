package dzh.com.JavaSE.com.characteristic.Anotation.Anno2_inherited;

import java.util.Arrays;

public class AppTest {
    public static void main(String[] args) {
        Class<Children> childrenClass = Children.class;
        System.out.println("获取得到父亲的注解以及自身的注解："+Arrays.toString(childrenClass.getAnnotations()));
        System.out.println("只获取自身注解："+ childrenClass.getDeclaredAnnotations());  //只获取自身的注解
    }
}
