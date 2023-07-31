package dzh.com.JavaSE.com.characteristic.Reflect;

import dzh.com.JavaSE.com.characteristic.Reflect.domain.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射是java语言的一个特性，它允程序在运行时（注意不是编译的时候）来进行自我检查并且对内部的成员进行操作。
 * 反射是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法,对于任意一个对象，都能够调用它的任意方法和属性,这种动态获取信息以及动态调用对象方法的功能称为java语言的反射机制。
 *
 * 动态性：程序运行的时候仍然可以动态的改变程序的结构的变量的类型
 *
 * Class.getAnnotations() 获取所有的注解，包括自己声明的以及继承的
 * Class.getAnnotation(Class< A > annotationClass) 获取指定的注解，该注解可以是自己声明的，也可以是继承的
 * Class.getDeclaredAnnotations() 获取自己声明的注解
 */
public class Constructor1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        getCla();
    }

    /**
     * 类名.class
     * 对象.getClass()
     * Class.forName(全类名)
     */
    private static void getCla() throws ClassNotFoundException {
        //通过forName方法获取class对象
        Class aClass= Class.forName("dzh.com.JavaSE.com.characteristic.Reflect.domain.Student");
        System.out.println(aClass);
        //通过class属性获取
        Class<Student> clazz2 = Student.class;
        System.out.println(clazz2);
        //3.getClass方法
        Student student=new Student();
        Class<? extends Student> clazz3 = student.getClass();
        System.out.println(clazz3);
    }

    private static void getString() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> aClass = Class.forName("java.lang.String");
        Constructor<?> constructor = aClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        String wc = (String) constructor.newInstance("卧槽");
        System.out.println(wc);
    }

    private static void getDeclaredConstructors(Class aClass) {
        //获取所有构造方法
        Constructor[] constructors = aClass.getDeclaredConstructors();
        System.out.println("获取所有构造方法");
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }

    private static void getDeclaredConstructor(Class aClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor declaredConstructor = aClass.getDeclaredConstructor(String.class);
        System.out.println("返回单个构造方法对象");
        System.out.println(declaredConstructor);
        // newInstance(Object...initargs)，根据指定的构造方法创建对象
        // setAccessible(boolean flag)，设置为true,表示取消访问检查，被私有的构造方法不能直接使用，暴力反射
        declaredConstructor.setAccessible(true);
        Student student = (Student) declaredConstructor.newInstance("张三");
        System.out.println(student);
    }

    private static void getConstructors(Class aClass) {
        // 返回所有公共构造方法对象的数组
        Constructor[] constructors = aClass.getConstructors();
        System.out.println("返回所有公共构造方法对象的数组");
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }

    private static void getConstructor(Class aClass) throws NoSuchMethodException {
        //返回单个公共的构造方法，参数必须一致
        Constructor constructor = aClass.getConstructor ();
        System.out.println("返回单个公共的构造方法，参数必须一致");
        System.out.println(constructor);
    }
}
