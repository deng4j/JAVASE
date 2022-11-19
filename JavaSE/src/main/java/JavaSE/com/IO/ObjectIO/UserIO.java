package JavaSE.com.IO.ObjectIO;

import JavaSE.com.IO.classloader.ClassLoaderTest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserIO {
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
