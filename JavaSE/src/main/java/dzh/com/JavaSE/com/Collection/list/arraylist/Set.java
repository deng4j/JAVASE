package dzh.com.JavaSE.com.Collection.list.arraylist;

import java.util.ArrayList;
import java.util.List;

public class Set {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(0,1,3,4));
        list.set(0,8);
        list.set(list.size()-1,8);
        System.out.println(list);
    }
}
