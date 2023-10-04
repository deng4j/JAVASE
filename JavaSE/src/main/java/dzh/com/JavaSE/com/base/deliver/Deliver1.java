package dzh.com.JavaSE.com.base.deliver;

import java.util.ArrayList;
import java.util.List;

/**
 * 引用传递，实际上是传递一个新的‘指向该引用地址的句柄’
 */
public class Deliver1 {

    private int a = 1;
    private String b = "1";

    public static void main(String[] args) {
        System.out.println("-------------test1-------------");

        // 句柄list
        List<String> list = new ArrayList<>();

        transfer(list);
        System.out.println(list);

        System.out.println("--------------------------");

        transfer1(list);
        System.out.println(list);

        System.out.println("--------------------------");

        transfer2(list);
        System.out.println(list);

        System.out.println("------------test2--------------");
        Deliver1 deliver1 = new Deliver1();
        transfer3(deliver1);
        System.out.println(deliver1.a);

    }

    public static void transfer(List<String> list) {
        list.add("1");
    }

    public static void transfer1(List<String> list) {
        list = null;
    }

    public static void transfer2(List<String> list) {
        List<String> list1 = list;
        list1.add("2");

        list1 = null;
    }

    public static void transfer3(Deliver1 deliver1) {
        deliver1.a = 2;
        deliver1.b = "2";
    }
}


