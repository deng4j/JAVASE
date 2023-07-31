package dzh.com.JavaSE.com.characteristic.Optional;

import dzh.com.JavaSE.com.characteristic.Optional.domain.Student;

import java.util.Optional;

/**
 * Optional 类是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象。
 * Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
 * Optional 类的引入很好的解决空指针异常。
 */
public class Optional1 {
    public static void main(String[] args) {
        ofNullableTest();
    }

    /**
     * 过滤器filter
     */
    private static void filterTest() {
        Student student = new Student("张三", 19);
        Optional.ofNullable(student).filter(u -> u.getAge() > 18).ifPresent(u -> System.out.println("The student age is more than 18."));

        Student student2 = new Student("张三", 18);
        Optional.ofNullable(student2).filter(u -> u.getAge() > 18).ifPresent(u -> System.out.println("The student age is more than 18."));
    }

    /**
     * 如果属性为Null就不赋值
     */
    private static void ifPresentTest() {
        Student student=null;

        Optional.ofNullable(student).ifPresent(s->s.setName("张三"));
        System.out.println("socialSecurityExp为null赋值："+student);

        student=new Student("张三",18);
        Optional.ofNullable(student).ifPresent(s->s.setName("张三"));
        System.out.println("socialSecurityExp不为null赋值："+student);
    }

    private static void newOptional() {
        // 1、创建一个包装对象值为空的Optional对象
        Optional<String> optStr = Optional.empty();
        // 2、创建包装对象值非空的Optional对象
        Optional<String> optStr1 = Optional.of("optional");
        // 3、创建包装对象值允许为空的Optional对象
        Optional<String> optStr2 = Optional.ofNullable(null);
    }

    /**
     * Optional.ofNullable(obj)：如果obj为null，返回一个空的Optional，否则返回一个有数据的Optional
     */
    private static void ofNullableTest() {
        Student student =new Student();

        Optional<String> optional = Optional.ofNullable(student).map(s -> s.getName());
        String str = optional.orElse("Unkown");
        System.out.println(str);

        student.setName("张三");
        Optional<String> optional1 = Optional.ofNullable(student).map(s -> s.getName());
        String str1 = optional1.orElse("Unkown");
        System.out.println(str1);
    }
}
