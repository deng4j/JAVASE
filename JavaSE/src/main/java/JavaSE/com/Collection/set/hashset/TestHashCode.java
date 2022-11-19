package JavaSE.com.Collection.set.hashset;

import JavaSE.com.Collection.set.hashset.set_domain.Student2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class TestHashCode {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat format=new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1=format.parse("2030-10-20 12:06:55");
        Date date2=format.parse("2028-10-20 12:06:55");
        Date date3=format.parse("2028-10-20 12:06:55");
        Date date4=format.parse("2016-10-20 12:06:55");

        Student2 student1 = new Student2("张三",1,date1);
        Student2 student2 = new Student2("李四",1,date2);
        Student2 student3 = new Student2("李四",1,date3);
        Student2 student4 = new Student2("王五",1,date4);

        HashSet<Student2> hashSet=new HashSet<>();
        hashSet.add(student1);
        hashSet.add(student2);
        hashSet.add(student3);
        hashSet.add(student4);
        System.out.println(hashSet);
    }
}
