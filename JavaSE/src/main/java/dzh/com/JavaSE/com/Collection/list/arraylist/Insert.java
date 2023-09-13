package dzh.com.JavaSE.com.Collection.list.arraylist;

import java.util.ArrayList;
import java.util.List;

public class Insert {
    public static void main(String[] args) {
        // 插入
        List<Integer> list = new ArrayList<>(List.of(0,1,3,4));
        list.add(2,2);
        System.out.println(list);
    }
}
