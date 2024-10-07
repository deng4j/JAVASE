package dzh.com.tools.gson;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 300084; i++) {
            list.add(i);
        }
        List<List<Integer>> partition = Lists.partition(list, 900);
        System.out.println(partition);
    }
}
