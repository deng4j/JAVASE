package JavaSE.com.Reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyUtil {
    private Object obj;
    private String fieldName;

    public static Object getProperty (Object obj, String fieldName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("所有构造");
        Constructor<?>[] declaredConstructors = obj.getClass().getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        System.out.println("所有成员属性");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("执行方法");
        Method[] methods = obj.getClass().getMethods();
        for (Method method : methods) {
            String[] split = method.toString().split(" ");
            String[] split1 = split[split.length - 1].split("\\.");
            String name=split1[split1.length-1];
            if (method.getReturnType().toString().equals("void")&&name.equals(fieldName+"()")){
               method.setAccessible(true);
                Method declaredMethod = obj.getClass().getDeclaredMethod(fieldName, null);
                declaredMethod.invoke(obj,null);
            }
        }
        return null;
    }

}
