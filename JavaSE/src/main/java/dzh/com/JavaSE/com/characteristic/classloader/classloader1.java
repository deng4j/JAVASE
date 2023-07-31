package dzh.com.JavaSE.com.characteristic.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * 不想给编译器看可以使用反射，在运行前创建对象。
 * path不以'/'开头时，我们就能获取与当前类所在的路径相同的资源文件，而以'/'开头时可以获取ClassPath根下任意路径的资源。
 * class.getResource("/") == class.getClassLoader().getResource("")
 *  "/" 表示在boot 加载器范围内
 *
 *  同一个类被不同加载器加载，jvm认为是不同类
 */
public class classloader1 {
    public static void main(String[] args) throws IOException {
        //获取加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        //使用当前类获取类加载器 classloader1.class.getClassLoader()

        InputStream is = systemClassLoader.getResourceAsStream("com/Reflect/File/prop.properties");
        Properties prop=new Properties();
        prop.load(is);
        System.out.println(prop);
        is.close();
        System.out.println("----------");

        //通过URL对象获取文件绝对路径
        URL resource = systemClassLoader.getResource("com/Reflect/File/prop.properties");
        String path=resource.getPath();
        System.out.println(path);


    }
}
