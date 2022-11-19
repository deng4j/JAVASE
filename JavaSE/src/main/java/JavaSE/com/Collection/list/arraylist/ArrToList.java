package JavaSE.com.Collection.list.arraylist;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrToList {

    public static void main(String[] args) {
        m2();
    }

    private static void m2() {
        int[] arr=new int[5];
        List<int[]> ints = Arrays.asList(arr);
    }

    private static void m1() {
        Integer[] arr=new Integer[5];
        arr[0]=1;
        arr[1]=2;
        List<Integer> list = Arrays.asList(arr);
        System.out.println(list);
    }
}
