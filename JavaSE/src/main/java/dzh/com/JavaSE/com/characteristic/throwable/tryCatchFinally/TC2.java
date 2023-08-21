package dzh.com.JavaSE.com.characteristic.throwable.tryCatchFinally;

import java.io.File;
import java.io.FileInputStream;

/**
 * JDK7 之后，Java 新增的 try-with-resource 语法糖来打开资源，并且可以在语句执行完毕后确保每个资源都被自动关闭 。
 * try-with-resources 语句中可以声明多个资源，方法是使用分号 ; 分隔各个资源。
 */
public class TC2 {

    public static void main(String[] args) {
        File file = new File("D:\\idea\\javas\\src\\com\\IO\\file\\folder\\a\\a.txt");
        //try()中需要一个AutoCloseable类型
        try(FileInputStream in=new FileInputStream(file)) {
            //一次可以读取1024个字节
            byte by[] =new byte[1024];
            int len=0;
            while(-1!=(len=in.read(by))){
                System.out.println(len);
                String str=new String(by,0,len);
                System.out.println("info:"+str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
