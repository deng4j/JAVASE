package dzh.com.JavaSE.com.Collection.list.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * Arrays.asList()创建一个固定大小的特殊数组，一旦创建就不能增删
 */
public class AsList {

    public static void main(String[] args) {
        m2();
    }

    /**
     * 基础类型
     */
    private static void m2() {
        int[] arr=new int[]{1,2,3};
        List<int[]> ints = Arrays.asList(arr);
    }

    /**
     * 包转类型
     */
    private static void m1() {
        Integer[] arr=new Integer[]{0,1};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(list);
    }
}
