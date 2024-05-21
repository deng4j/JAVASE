package dzh.com.algorithm;

import java.util.List;

public class Symmetry {
    public static void main(String[] args) {
        /**
         * 原数据：1, 2, 3,
         * 改变后：3,   1, 2, 3,   1
         *
         * 找对称。如输入4，输出1；输入0，输出3；
         *
         *
         * 原数据：1, 2,
         * 改变后：2,  1, 2,  1
         *
         * 找对称。如输入0，输出2；输入3，输出1；
         *
         * 原数据：1, 2, 3, 4
         * 改变后：4,  1, 2, 3, 4,  1
         *
         * 找对称。如输入0，输出4；输入5，输出1；
         */

        List<Integer> list = List.of(4,  1, 2, 3, 4,  1);
        int index = 3;
        if (index==0||index==list.size()-1){
            System.out.println(Math.abs(index - (list.size() - 2)));
        }else {
            System.out.println(index);
        }
    }
}
