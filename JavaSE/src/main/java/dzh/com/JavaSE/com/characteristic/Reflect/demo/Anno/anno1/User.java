package dzh.com.JavaSE.com.characteristic.Reflect.demo.Anno.anno1;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
* description: 创建一个普通的类，使用 @ConsAnnotation、@Fields 注解。
* @version v1.0
* @author w
* @date 2018年8月1日下午2:50:23
*/
@ConsAnnotation(request = { "hello","world","annotation!" })
public class User {
 
    @Fields("中华人民共和国")
    private String userName;
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        User user = new User();
        // 1、 获取 User类上的注解 @ConsAnnotation
        ConsAnnotation anno = user.getClass().getAnnotation(ConsAnnotation.class);
        String[] arr = anno.request();
        System.out.println(Arrays.toString(arr)); // [hello, world, annotation!]

        // 2、 获取User类中 private String userName; 变量上的注解 @Field
        Field f = user.getClass().getDeclaredField("userName");
        Fields anno2 = f.getAnnotation(Fields.class);
        System.out.println(anno2.value());
    }
}
 