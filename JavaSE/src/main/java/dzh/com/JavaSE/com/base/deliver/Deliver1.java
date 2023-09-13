package dzh.com.JavaSE.com.base.deliver;

import java.util.ArrayList;
import java.util.List;

/**
 * 引用传递
 */
public class Deliver1 {

    public static void main (String[] args){
        List<String> list = new ArrayList<>();
        transfer(list);
        System.out.println(list);
    }

    public static void transfer(List<String> list){
        list.add("1");
    }
}


