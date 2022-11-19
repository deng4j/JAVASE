package JavaSE.com.Collection.set.hashset;

import JavaSE.com.Collection.set.hashset.set_domain.Student1;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 数组+链表/红黑树
 * 默认长度16，0.75后扩容2倍
 * 当链表长度大于8，table表长度小于64时，每次添加元素，table扩容。
 * 当链表长度大于8，table表长度大于64时，时转成红黑树
 * 底层是hashmap
 * hashset按hashcode排序，hashcode值一样会生成链表
 * 是无序不重复的，允许为null
 * 如果hashcode相同，用equals比较，生成一个链表，jdk1.8新元素在最后面
 *
 * hashset底层是使用hashmap，用map的key储存，value指向同一地址。
 *
 */
public class HashSet1 {
    public static void main(String[] args) {
        HashSet<Student1> hashSet=new HashSet<>();
        Student1 s1=new Student1("张三",18,34);
        Student1 s2=new Student1("李四",19,34);
        Student1 s3=new Student1("王五",15,89);

        boolean flag = s1.equals(s3);
        System.out.println(flag);

        hashSet.add(null);
        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);
        Iterator<Student1> iterator=hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        hashSet.remove(new Student1("张三",19,34));
        System.out.println(hashSet);
    }
}
