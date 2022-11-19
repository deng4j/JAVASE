package JavaSE.com.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class While_Drop {

    public static void main(String[] args) {
        m1();
    }

    /**
     * 获取或者放弃元素
     */
    private static void m1() {
        List<Integer> list1 = Stream.of(1, 2, 3, 2, 1).
            dropWhile(n -> n < 3).
            collect(Collectors.toList());
        System.out.println(list1);

        List<Integer> list2 = Stream.of(1, 2, 3, 2, 1).
            takeWhile(n -> n < 3).
            collect(Collectors.toList());
        System.out.println(list2);
    }
}
