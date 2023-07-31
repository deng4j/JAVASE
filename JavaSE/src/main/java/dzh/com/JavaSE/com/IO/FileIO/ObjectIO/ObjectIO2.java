package dzh.com.JavaSE.com.IO.FileIO.ObjectIO;

import dzh.com.JavaSE.com.IO.FileIO.classloader.ClassLoaderTest;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * 对象只要实现了Serilizable接口，这个对象就可以被序列化
 * transient关键字使得这个字段的生命周期仅存于调用者的内存中而不会写到磁盘里持久化。
 */
@Data
@AllArgsConstructor
class Usre implements Serializable {
    //指定序列化值,防止修改对象从而改变序列号
    private static final long serialVersionUID = 1L;
    private int uid;
    private String pwd;
    // 不序列化字段
    private transient String name;
    // 一个静态变量，不管是否被transient修饰，均不能被序列化
    private static Integer phone=123445;
}

public class ObjectIO2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String classPath = ClassLoaderTest.class.getClassLoader().getResource("").getPath();

        File file=new File(classPath+"io/folder/d/user.txt");
        Usre s1 = new Usre(120, "123456", "张三");
        Usre s2 = new Usre(128, "123456", "李四");
        Usre s3 = new Usre(170, "123456", "王五");
        ArrayList<Usre> list=new ArrayList<>(List.of(s1,s2,s3));
        write(file, list);
        read(file);
    }

    private static void read(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)
                )
        );

        Object obj;
        try {
            while (true){
                obj=ois.readObject();
                if (obj instanceof List){
                    ArrayList<Usre> u= (ArrayList<Usre>) obj;
                    System.out.println(u);
                }
            }
        } catch (EOFException e) {
        }finally {
            if (null!=ois){
                ois.close();
            }
        }
    }


    private static void write(File file, ArrayList<Usre> s1) throws IOException {
        ObjectOutputStream oos=new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                )
        );
        oos.writeObject(s1);
        oos.flush();
        oos.close();
    }
}
