package dzh.com.JavaSE.com.Collection.list.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class RemoveIf {
    public static void main(String[] args) {
        ArrayList<String> clist=new ArrayList<>();
        clist.add("a");
        clist.add("b");
        clist.add("c");

        //removeif要实现Predicate接口
        clist.removeIf((String s)->{
            return s.length()>3;
        });

        System.out.println(clist);


        Iterator<String> iterator=clist.iterator();
        while (iterator.hasNext()){
            String s=iterator.next();
            if ("b".equals(s)){
                iterator.remove();
            }
        }
        //到这里，iterator.hasNext()已经移动到最后了
        System.out.println(clist);
    }
}
