package dzh.com.JavaSE.com.base.baseType.strings;

import java.util.Arrays;
import java.util.List;

public class toArray {

    public static void main(String[] args) {
        List<String> sampleList = Arrays.asList("张三", "java 11");
        // array = {"张三", "java 11"};
        String[] array = sampleList.toArray(String[]::new);

        List<String> array1 = List.of(array);
        System.out.println(array1);
    }
}
