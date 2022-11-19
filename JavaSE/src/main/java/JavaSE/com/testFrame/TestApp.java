package JavaSE.com.testFrame;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**一：
 * 模拟小框架，可以对某一个类中的所有方法进行测试
 * 如果运行期间出现问题，将产生时间，方法名字，异常名字，原因等记录到日志文件中
 * 二：
 * 自定义一个注解,保留到Runtime阶段
 */
public class TestApp {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("com/testFrame/person.properties");
        Properties prop=new Properties();
        prop.load(is);
        is.close();
        String className = prop.getProperty("className");
        Class<?> aClass = Class.forName(className);
        Constructor<?> constructor = aClass.getConstructor();
        constructor.setAccessible(true);
        TestDemo testDemo = (TestDemo) constructor.newInstance();
        Method[] declaredMethods = aClass.getDeclaredMethods();

        BufferedWriter br=new BufferedWriter(new FileWriter(
                new File("D:/idea/javas/src/com/testFrame/log.log")
        ));
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Anno.class)){
                declaredMethod.setAccessible(true);
                try {
                    declaredMethod.invoke(testDemo);
                } catch (Exception e) {
                    br.write(format.format(new Date())+":");
                    br.write(declaredMethod.getName()+"----");
                    //获得Throwale对象
                    br.write(e.getCause().getClass().getSimpleName());
                    br.write("原因:"+e.getCause().getMessage());
                    br.newLine();
                    br.flush();
                }
            }
        }
        br.close();

    }

}
