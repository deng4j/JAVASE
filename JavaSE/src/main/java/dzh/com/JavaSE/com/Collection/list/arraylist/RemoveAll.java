package dzh.com.JavaSE.com.Collection.list.arraylist;

import java.util.ArrayList;
import java.util.HashSet;

public class RemoveAll {

    static class Student{
        private String name;
        
        private String sex;

        public Student(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Student{" + "name='" + name + '\'' + ", sex='" + sex + '\'' + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Student student = (Student)o;

            return name != null ? name.equals(student.name) : student.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }


    public static void main(String[] args) {
        m3();
    }

    private static void m2() {
        HashSet<Student> studentHashSet=new HashSet<>();
        studentHashSet.add(new Student("张三", "1"));
        studentHashSet.add(new Student("李四", "1"));
        studentHashSet.add(new Student("王五", "1"));

        HashSet<Student> studentHashSet2=new HashSet<>();
        studentHashSet2.add(new Student("张三", "1"));
        studentHashSet2.add(new Student("李四", "1"));

        //studentHashSet.removeAll(studentHashSet2);

        //以被retainAll的集合为基准
        studentHashSet.retainAll(studentHashSet2);
        System.out.println(studentHashSet);
    }

    private static void m1() {
        ArrayList<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);

        ArrayList<Long> list2 = new ArrayList<>();
        list2.add(1L);
        list2.add(4L);
        //差集
        //list.removeAll(list2);
        System.out.println(list);
        //交集
        ArrayList<Long> list3 = new ArrayList<>();
        list3.add(2L);
        list.retainAll(list3);
        System.out.println(list);
    }

    private static void m3() {
        ArrayList<Long> list1 = new ArrayList<>();
        list1.add(1L);
        list1.add(2L);
        list1.add(3L);

        ArrayList<Long> list2 = new ArrayList<>();
        list2.add(1L);
        list2.add(4L);
        //差集
        list2.forEach(list1::remove);
        System.out.println(list1);
    }
}