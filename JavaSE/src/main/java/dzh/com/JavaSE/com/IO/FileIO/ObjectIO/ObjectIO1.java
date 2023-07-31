package dzh.com.JavaSE.com.IO.FileIO.ObjectIO;

import dzh.com.JavaSE.com.IO.FileIO.classloader.ClassLoaderTest;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

@Data
@AllArgsConstructor
class Emloyee implements Serializable {
    private transient String name;
    private int salary;
}

/**
 * java序列化的作用有两个，网络传输、对象持久化
 * Java序列化的缺点：java序列化使用的是私有协议，无法跨语言反序列化
 */
public class ObjectIO1 {
    public static void main(String[] args) {
        String classPath = ClassLoaderTest.class.getClassLoader().getResource("").getPath();
        File file=new File(classPath+"io/file/employee.txt");
        Emloyee e1=new Emloyee("张三",10000);
        try {
            Seri(file,e1);
            read(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *  反序列化,注意，读取顺序和写入顺序一致
     *  读到末尾会再读会跑异常
     */
    private static void read(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(
                new FileInputStream(file)
        ));
        Object obj=ois.readObject();
        //向下转型
        if (obj instanceof Emloyee){
            Emloyee em=(Emloyee)obj;
            System.out.println(em.getName()+"----"+em.getSalary());
        }
    }

    //序列化
    private static void Seri(File file, Emloyee em) throws IOException {
        ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream(file)
        ));
        oos.writeObject(em);
        oos.close();
    }
}
