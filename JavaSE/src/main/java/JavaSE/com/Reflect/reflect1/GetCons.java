package JavaSE.com.Reflect.reflect1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * + 类名.class属性
 *
 * + 对象名.getClass()方法
 *
 * + Class.forName(全类名)方法
 * 动态性：程序运行的时候仍然可以动态的改变程序的结构的变量的类型
 */
public class GetCons {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //通过forName方法获取class对象
        Class aClass= Class.forName("JavaSE.com.Reflect.reflect1.Student");
        System.out.println(aClass);
        //通过class属性获取
        Class<Student> clazz2 = Student.class;
        System.out.println(clazz2);
        //3.getClass方法
        Student student=new Student();
        Class<? extends Student> clazz3 = student.getClass();
        System.out.println(clazz3);
        getDeclaredConstructor(aClass);
        System.out.println("--------------");
        getDeclaredConstructors(aClass);
        System.out.println("--------------");
        getConstructor(aClass);
        System.out.println("--------------");
        getConstructors(aClass);


        getString();



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
        //| T newInstance(Object...initargs) | 根据指定的构造方法创建对象 |
        //| setAccessible(boolean flag)      | 设置为true,表示取消访问检查|
        //被私有的构造方法不能直接使用，暴力反射
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
