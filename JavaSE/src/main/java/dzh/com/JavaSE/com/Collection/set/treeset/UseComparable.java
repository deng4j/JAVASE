package dzh.com.JavaSE.com.Collection.set.treeset;

import dzh.com.JavaSE.com.Collection.set.treeset.domain.Student;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 自然排序
 */
public class UseComparable {
    public static void main(String[] args) {
        TreeSet<Student> set=new TreeSet<>();
        Student s1=new Student("张三",18);
        Student s2=new Student("李四",18);
        Student s4=new Student("刘六",187);
        Student s3=new Student("王五",135);

        set.add(s1);
        set.add(s2);
        set.add(s4);
        set.add(s3);


        Iterator<Student> i=set.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }
}
