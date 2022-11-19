package JavaSE.com.Anotation.Anotation2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.Anotation.Anotation2.TestAnon");
        TestAnon testAnon = (TestAnon) aClass.newInstance();

        Method[] declaredMethods = aClass.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            //如果方法上有@test这个注解返回true
            if (declaredMethod.isAnnotationPresent(test.class)){
                declaredMethod.invoke(testAnon);
            }
        }
    }
}
