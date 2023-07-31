package dzh.com.JavaSE.com.characteristic.var;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Var2 {

    public static void main(String[] args) {
        n2();

        m1();
    }

    private static void n2() {
        List<String> sampleList = Arrays.asList("张三", "java 11","jack");
        List<String> result = sampleList.stream()
            // 过滤以j开头的字符串
            .filter((var s) -> s.startsWith("j"))
            // 同时不包含11的字符串
            .filter(Predicate.not((var s) -> s.contains("11")))
            .collect(Collectors.toList());

        System.out.println(result);
    }

    private static void m1() {
        Consumer<String> consumer1= t->System.out.println(t.toUpperCase());

        Consumer<String>consumer2=(var t)->System.out.println(t.toUpperCase());
        consumer2.accept("aa");
    }
}
