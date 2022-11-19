package JavaSE.com.Collection.list.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 并发修改异常是因为 ：预期修改次数！=实际修改次数
 * 如果用集合的方法remove()删除的是倒数第二个，指针==size。则循环停止
 */
public class MyList {
    public static void main(String[] args) {
        ArrayList<String> clist=new ArrayList<>();
        clist.add("a");
        boolean b = clist.add("b");
        clist.add("c");
        //removeif要实现Predicate接口
        clist.removeIf((String s)->{
            return s.length()>3;
        });

        System.out.println(clist.toString());


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
