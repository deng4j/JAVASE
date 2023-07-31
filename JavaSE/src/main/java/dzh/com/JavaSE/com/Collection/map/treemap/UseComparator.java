package dzh.com.JavaSE.com.Collection.map.treemap;

import dzh.com.JavaSE.com.Collection.map.treemap.domain.Student1;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class UseComparator {
    public static void main(String[] args) {
        Comparator<Student1> comparator=(Student1 s1, Student1 s2)->{
            return  s1.getAge()-s2.getAge()==0?s1.getNaem().compareTo(s2.getNaem()): s1.getAge()-s2.getAge();

        };
        Map<Student1,String> map=new TreeMap<>(comparator);
        Student1 s1=new Student1("张三",15);
        Student1 s2=new Student1("李四",17);
        Student1 s3=new Student1("王五",13);
        Student1 s4=new Student1("赵柳",18);
        map.put(s1,"1212");
        map.put(s2,"1242");
        map.put(s3,"1822");
        map.put(s4,"2322");
        System.out.println(map);

    }
}

