package dzh.com.DesignPattern.DesignPattern.ProtoType.sheep;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, IOException, ClassNotFoundException {
        m1();
    }

    private static void m3() throws IOException, ClassNotFoundException, CloneNotSupportedException {
        Date date=new Date();
        Sheep sheep = new Sheep("母体",date);

        Sheep clone = (Sheep) sheep.clone();
        System.out.println(sheep==clone);

        //使用序列化和反序列化进行深度克隆
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(sheep);
        byte[] bytes = bos.toByteArray();

        ByteArrayInputStream bis=new ByteArrayInputStream(bytes,0,bytes.length);
        ObjectInputStream ois=new ObjectInputStream(bis);
        Object obj = ois.readObject();

        date.setYear(20);
        if (obj instanceof Sheep){
            Sheep sheep1= (Sheep) obj;
            System.out.println("反序列化前的："+ sheep);
            System.out.println("反序列化后的sheep对象："+sheep1);
            System.out.println(sheep1.getName()== sheep.getName());
        }
    }

    private static void m1() throws CloneNotSupportedException {
        Date date=new Date();
        Sheep sheep = new Sheep("母体",date);

        Sheep clone = (Sheep) sheep.clone();
        System.out.println(sheep==clone);
        System.out.println(sheep.getClass()==clone.getClass());

        //深克隆后，修改了date对象，而clone对象中的date对象没有改变，
        // 说明sheep对象和clone对象中的date对象指向的不是同一个，
        //删除Sheep中clone()方法中深克隆代码对比
        date.setTime(131565646);

        System.out.println("母体："+ sheep);
        System.out.println("克隆羊:"+ clone);
        System.out.println( sheep.getDate()== clone.getDate());
        //未对name属性进行修改,且没有对name属性进行深克隆，指向同一个String对象
        System.out.println(sheep.getName()== clone.getName());
    }

    private static void m2() throws NoSuchFieldException, IllegalAccessException, CloneNotSupportedException {
        Date date=new Date();
        Sheep sheep = new Sheep("母体",date);

        Sheep clone = (Sheep) sheep.clone();

        clone.setName("多利");
        //通过反射修改
        Class<? extends Sheep> aClass = sheep.getClass();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(sheep,"小米");

        System.out.println("母体："+sheep);
        System.out.println("克隆羊:"+clone);
        System.out.println( sheep.getDate()==clone.getDate());
    }
}
