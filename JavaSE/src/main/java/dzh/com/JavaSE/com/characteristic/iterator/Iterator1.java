package dzh.com.JavaSE.com.characteristic.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Java迭代器（Iterator）是 Java 集合框架中的一种机制，是一种用于遍历集合（如列表、集合和映射等）的接口。
 */
public class Iterator1 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("def");
        list.add("def");
        list.add("aa");
        list.add("def");

        Iterator<String> i=list.iterator();
        while (i.hasNext()){
            String s=i.next();
            if (s.equals("def")){
                i.remove();
            }
        }
        System.out.println(list);
    }
}
