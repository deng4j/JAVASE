package dzh.com.JavaSE.com.characteristic.Reflect;

import dzh.com.JavaSE.com.characteristic.Reflect.domain.Student;

import java.lang.reflect.Field;

public class Fieds1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> aClass = Class.forName("dzh.com.JavaSE.com.characteristic.Reflect.domain.Student");
        getField(aClass);
        getFields(aClass);
        getDeclaredField(aClass);
        getDeclaredFields(aClass);


    }

    private static void getField(Class<?> aClass) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        //返回公共的单个成员变量,注意成员名字一致
        System.out.println("返回公共的单个成员变量,注意成员名字一致");
        Field age = aClass.getField("age");
        //返回成员名字
        String name = age.getName();
        //获取成员属性类型
        Class<?> type = age.getType();
        System.out.println(name);
        System.out.println(type);

        //set给成员赋值
        //取消检查访问
        age.setAccessible(true);
        //指定对象赋值
        Student student = (Student) aClass.newInstance();
        age.set(student,88);
        //get得到成员属性
        Object o = age.get(student);
        System.out.println("赋值后:"+o);

    }

    private static void getFields(Class<?> aClass) {
        //返回所有公共的成员属性
        System.out.println("返回所有公共的成员属性");
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }

    private static void getDeclaredField(Class<?> aClass) throws NoSuchFieldException {
        //无视修饰符返回单个属性
        System.out.println("无视修饰符返回单个属性");
        Field id = aClass.getDeclaredField("id");
        System.out.println(id);
    }


    private static void getDeclaredFields(Class<?> aClass) {
        //无视修饰符返回所有成员属性
        System.out.println("无视修饰符返回所有成员属性");
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }
}
