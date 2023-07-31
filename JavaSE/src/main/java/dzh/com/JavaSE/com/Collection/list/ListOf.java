package dzh.com.JavaSE.com.Collection.list;

import java.util.List;

public class ListOf {

    public static void main(String[] args) {
        List<String> list = List.of("1", "2");
        List<String> list1 = List.copyOf(list);
        System.out.println(list);
        System.out.println(list1);
    }
}
