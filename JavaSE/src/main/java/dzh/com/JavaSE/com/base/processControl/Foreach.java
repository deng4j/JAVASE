package dzh.com.JavaSE.com.base.processControl;

import java.util.List;

/**
 * For-Each遍历是基于迭代器，想要使用Foreach，必须实现Iterable接口
 */
public class Foreach {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
