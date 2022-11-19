package JavaSE.com.exception.tryCatch;

import java.io.File;
import java.io.FileInputStream;

public class demo2 {

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
