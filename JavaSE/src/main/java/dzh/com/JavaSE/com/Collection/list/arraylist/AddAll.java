package dzh.com.JavaSE.com.Collection.list.arraylist;

import dzh.com.JavaSE.com.Collection.list.arraylist.domain.Student;

import java.util.ArrayList;

public class AddAll {

    public static void main(String[] args) {
        Student student1 = new Student("张三");
        Student student2 = new Student("李四");

        ArrayList<Object> objects = new ArrayList<>(3);
        objects.add(student1);
        objects.add(student2);

        ArrayList<Object> list = new ArrayList<>();
        list.add(null);
        list.addAll(objects);
        student1.setName("嘻嘻嘻");
        System.out.println(list);
    }
}
