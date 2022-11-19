package bjsxt.com.io.ObjectIO;

import java.io.*;

public class ObjectIO {
    public static void main(String[] args) {
        File file=new File("D:/idea/bjsxt/src/com/io/file/employee.txt");
        emloyee e1=new emloyee("张三",10000);
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
     * @param file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static void read(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(
                new FileInputStream(file)
        ));
        Object obj=ois.readObject();
        //向下转型
        if (obj instanceof emloyee){
            emloyee em=(emloyee)obj;
            System.out.println(em.getName()+"----"+em.getSalary());
        }
    }



    //序列化
    private static void Seri(File file,emloyee em) throws IOException {
        ObjectOutputStream oos=new ObjectOutputStream(new BufferedOutputStream(
                new FileOutputStream(file)
        ));
        oos.writeObject(em);
        oos.close();
    }
}
