package dzh.com.JavaSE.com.Collection.list.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * jdk中只有双链表
 * 有序重复，可以为null
 * 链表使用顺序访问（iterator）比随机访问（get(i)）快。
 * listIterator(int index)Java中AbstractList类的方法用于从列表中
 * 的指定位置开始，在此列表中的元素上返回列表迭代器。
 */
public class linkedlist1 {
    public static void main(String[] args) {
        LinkedList<String > list=new LinkedList<>();

        list.add("a");
        list.add("a");
        list.add("b");
        list.add(2,null);
        System.out.println("---"+list.size());
        Iterator<String> iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
