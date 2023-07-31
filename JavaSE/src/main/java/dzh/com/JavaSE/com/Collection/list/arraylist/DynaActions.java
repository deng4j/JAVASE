package dzh.com.JavaSE.com.Collection.list.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 动态操作列表中的元素
 */
public class DynaActions {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("bb");
        list.add("aa");
        list.add("cc");
        list.add("dd");
        list.add("ee");

        foreach1(list);
    }

    /**
     * ArrayList里还保存了一个变量modCount，用来记录List修改的次数，而iterator保存了一个expectedModCount来表示期望的修改次数，
     * 在每个操作前都会判断两者值是否一样，不一样则会抛出异常；
     *
     * 在foreach循环中调用remove()方法后，会走到fastRemove()方法，该方法不是iterator中的方法，
     * 而是ArrayList中的方法，在该方法中modCount++; 而iterator中的expectedModCount却并没有改变；
     */
    private static void foreach1(ArrayList<String> list) {
        for (String s : list) {
            if (s.equals("aa")){
                // 会出现并发修改异常
                list.remove("aa");
            }
        }
    }

    private static void foreach2() {
        ArrayList<String> list=new ArrayList<>();
        list.add("bb");
        list.add("aa");
        list.add("cc");
        list.add("dd");
        list.add("ee");

        for (String s : list) {
            if (s.equals("dd")){
                /**
                 * 当删除的是倒数第二个元素的时候，不会出现并发修改异常，这是一个巧合，指针==size。则循环停止
                 */
                list.remove("dd");
            }
        }

        System.out.println(list);
    }

    private static void forOp(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("aa")){
                list.remove("aa");
            }
        }
    }

    private static void iter(ArrayList<String> list) {
        Iterator<String> i = list.iterator();
        while (i.hasNext()){
            String s=i.next();
            if (s.equals("aa")){
                // 使用迭代器进行操作避免出现并发修改异常
                i.remove();
            }
        }
    }
}
