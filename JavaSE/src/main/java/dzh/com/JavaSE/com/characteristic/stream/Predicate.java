package dzh.com.JavaSE.com.characteristic.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Predicate {

    public static void main(String[] args) {
        List<String> sampleList = Arrays.asList("张三", "java 11","jack");

        List<String> result = sampleList.stream()
            // 过滤以j开头的字符串
            .filter(s -> s.startsWith("j"))
            // 同时不包含11的字符串
            .filter(java.util.function.Predicate.not(s -> s.contains("11")))
            .collect(Collectors.toList());

        System.out.println(result);
    }
}
