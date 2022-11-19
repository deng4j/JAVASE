package JavaSE.com.Collection.map.treemap;

import JavaSE.com.Collection.map.treemap.treemap_domain.Student3;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class mytreemap {
    public static void main(String[] args) {
        Comparator<Student3> comparator=(Student3 s1, Student3 s2)->{
            return  s1.getAge()-s2.getAge()==0?s1.getNaem().compareTo(s2.getNaem()): s1.getAge()-s2.getAge();

        };
        Map<Student3,String> map=new TreeMap<>(comparator);
        Student3 s1=new Student3("张三",15);
        Student3 s2=new Student3("李四",17);
        Student3 s3=new Student3("王五",13);
        Student3 s4=new Student3("赵柳",18);
        map.put(s1,"1212");
        map.put(s2,"1242");
        map.put(s3,"1822");
        map.put(s4,"2322");
        System.out.println(map);

    }
}
