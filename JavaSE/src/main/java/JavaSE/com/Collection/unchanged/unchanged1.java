package JavaSE.com.Collection.unchanged;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class unchanged1 {
    public static void main(String[] args) {
        //不可变集合
        List<String> unlist = List.of("张三", "张良", "张健康", "大傻傻");
        //集合的批量添加
        ArrayList<String> list = new ArrayList<>(unlist);
        System.out.println(list);
        //使用stream方法
        Stream<String> stringStream = list.stream().filter(li -> li.startsWith("张")).filter(li -> li.length() == 3);
        stringStream.forEach(s -> System.out.println(s));
    }
}
