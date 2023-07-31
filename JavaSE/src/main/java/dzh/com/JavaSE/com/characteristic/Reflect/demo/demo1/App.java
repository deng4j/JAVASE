package dzh.com.JavaSE.com.characteristic.Reflect.demo.demo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;

/**
 * 根据配置文件，配置信息，创建对象
 * 只需要修改配置文件的信息即可
 */
public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        URL url = systemClassLoader.getResource("com/Reflect/case1/prop.properties");
        System.out.println(url);
        //这里不使用InputStream resourceAsStream = systemClassLoader.getResourceAsStream("com/Reflect/case1/prop.properties");
       InputStream is=new FileInputStream(new File(url.getPath()));
        Properties prop=new Properties();
        prop.load(is);
        is.close();
        //获取信息
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");
        String fieldName = prop.getProperty("fieldName");
        String fieldValue = prop.getProperty("fieldValue");

        //反射
        //获取指定类的class对象
        Class<?> aClass = Class.forName(className);
        //获取对象属性
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        //取消访问权限
        declaredConstructor.setAccessible(true);
        Object obj = declaredConstructor.newInstance();
        //过去成员变量，方法
        Field declaredField = aClass.getDeclaredField(fieldName);
        //取消权限
        declaredField.setAccessible(true);
        //给成员变量赋值
        declaredField.set(obj,fieldValue);
        //取值
        Object value= declaredField.get(obj);
        System.out.println("成员属性："+value);
        //---------------------------------------------
        //"获取成员方法且使用"
        //有参数的方法要判断
        Method declaredMethod = aClass.getDeclaredMethod(methodName);
        declaredMethod.setAccessible(true);
        Object result = declaredMethod.invoke(obj);
        System.out.println("返回结果："+result);
    }
}
