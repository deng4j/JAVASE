package JavaSE.com.OptionalDemo;


import JavaSE.com.OptionalDemo.domain.Student;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        ofNullableTest();
    }

    private static void filterTest() {
        //过滤器filter
        Student student=new Student("张三",19);
        student.filterAge();

        Student student2=new Student("张三",18);
        student2.filterAge();
    }

    private static void ifPresentTest() {
        //如果属性为Null就不赋值
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

    private static void ofNullableTest() {
        //Optional.ofNullable(obj)，如果obj为null，返回一个空的Optional，否则返回一个有数据的Optional

        Student student =new Student();
        System.out.println("name为Null："+student.getStudentName());
        student.setName("张三");
        System.out.println("name不为Null："+student.getStudentName());
    }
}
