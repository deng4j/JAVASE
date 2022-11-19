package JavaSE.com.Collection.list.arraylist;

import java.util.List;

public class ListOf {

    public static void main(String[] args) {
        //jdk9特性
        List<String> list = List.of("1", "2");
        List<String> list1 = List.copyOf(list);
        System.out.println(list);
        System.out.println(list1);
    }
}
