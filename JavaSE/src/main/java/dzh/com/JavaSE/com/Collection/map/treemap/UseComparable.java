package dzh.com.JavaSE.com.Collection.map.treemap;

import dzh.com.JavaSE.com.Collection.map.treemap.domain.Student;

import java.util.Map;
import java.util.TreeMap;

/**
 * 测试实现Comparable接口
 */
public class UseComparable {

    public static void main(String[] args) {
        Map<Student,String> map=new TreeMap<>();
        Student s1=new Student("张三",15);
        Student s2=new Student("李四",17);
        Student s3=new Student("王五",13);
        Student s4=new Student("赵柳",18);
        map.put(s1,"1212");
        map.put(s2,"1242");
        map.put(s3,"1822");
        map.put(s4,"2322");
        System.out.println(map);
    }
}



