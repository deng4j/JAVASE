package dzh.com.JavaSE.com.Collection.list.arrays;

import java.util.Arrays;

public class Copy {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2};

        // 拷贝到新数组，长度自定义
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
    }
}
