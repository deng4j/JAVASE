package dzh.com.JavaSE.com.Collection.set.treeset;

import dzh.com.JavaSE.com.Collection.set.treeset.domain.Student2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * treeset是有序不重复的，不允许为null
 *
 * 比较器排序，解耦
 * 二叉树一个节点最多有两个子节点
 * 二叉平衡数，左右子树高度不超过1，左旋，右旋机制保证是一个平衡二叉树
 */
public class UseComparator {
    public static void main(String[] args) {
        //lambda
        Comparator<Student2> comparator=(Student2 s1, Student2 s2)->{
            return (s1.getAge()-s2.getAge())==0?(s1.getName().compareTo(s2.getName())):(s1.getAge()-s2.getAge());
        };
        //二叉树的中序遍历
        TreeSet<Student2> set=new TreeSet<>(comparator);
        Student2 s1=new Student2("张三",18);
        Student2 s2=new Student2("李四",18);
        Student2 s3=new Student2("王五",135);
        Student2 s4=new Student2("刘六",187);

        set.add(s3);
        set.add(s1);
        set.add(s2);
        set.add(s4);



        Iterator<Student2> i=set.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }
}
