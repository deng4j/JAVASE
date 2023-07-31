package dzh.com.JavaSE.com.characteristic.Reflect;

import dzh.com.JavaSE.com.characteristic.Reflect.domain.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 静态方法不需要对象调
 * getMethod的内部实现是去查找跟你给定参数Class列表严格一致的方法，没有考虑继承关系。
 * main.invoke(null,(Object) new String[]{});
 */
public class Method1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class aClass = Class.forName("dzh.com.JavaSE.com.characteristic.Reflect.domain.Student");
        getReturnType(aClass);
    }

    private static void getDeclaredMethod(Class aClass) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //无视修饰符返回单个成员方法
        System.out.println("无视修饰符返回单个成员方法");
        Method eat = aClass.getDeclaredMethod("eat", String.class);
        System.out.println(eat);
        //invoke方法的使用,先创建一个调用者
        Student student = (Student) aClass.newInstance();
        //取消权限访问
        eat.setAccessible(true);
        Object food = eat.invoke(student, "苹果");
        System.out.println(food);

    }

    /**
     * 无视修饰获取所有的成员方法，不包括继承来的
     */
    private static void getDeclaredMethods(Class aClass) {
        Method[] declaredMethods = aClass.getDeclaredMethods();
        System.out.println("获取所有的成员方法，不包括继承来的");
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

    /**
     * 返回单个公共的成员方法
     */
    private static void getMethod(Class aClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Student student = new Student();

        Method work = aClass.getMethod("work");
        System.out.println(work);
        work.invoke(student);

        Method work1 = aClass.getMethod("work",int.class);
        System.out.println(work1);
        work1.invoke(student,1);
    }

    /**
     * 返回多个公共的方法，包括继承来的
     */
    private static void getMethods(Class aClass) {
        Method[] methods = aClass.getMethods();
        System.out.println("返回多个公共的方法，包括继承来的");
        for (Method method : methods) {
            System.out.println(method);
        }
    }


    private static void getReturnType(Class aClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method work = aClass.getMethod("work");
        System.out.println(work);
        System.out.println("返回类型："+work.getReturnType());
    }

}
