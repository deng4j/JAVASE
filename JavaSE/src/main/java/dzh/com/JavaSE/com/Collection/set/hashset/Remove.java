package dzh.com.JavaSE.com.Collection.set.hashset;

import dzh.com.JavaSE.com.Collection.set.hashset.domain.Student3;

import java.util.HashSet;

public class Remove {
    public static void main(String[] args) {
        HashSet<Student3> hashSet=new HashSet<>();
        Student3 s1=new Student3("张三",18);
        Student3 s2=new Student3("李四",19);
        Student3 s3=new Student3("王五",15);
        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);


        hashSet.remove(new Student3("张三",19));
        System.out.println(hashSet);
    }
}
