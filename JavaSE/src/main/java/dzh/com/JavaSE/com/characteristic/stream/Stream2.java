package dzh.com.JavaSE.com.characteristic.stream;

import java.util.Arrays;
import java.util.List;

/**
 * parallelStream 是流并行处理程序的代替方法。
 */
public class Stream2 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("空字符串的数量："+count);
    }
}
