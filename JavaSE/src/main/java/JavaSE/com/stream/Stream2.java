package JavaSE.com.stream;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream2 {
    public static void main(String[] args) {
        Map<String, String> mapof = Map.ofEntries(Map.entry("孙悟空", "紫霞仙子"), Map.entry("猪八戒", "高翠花"), Map.entry("沙和尚", "无"), Map.entry("唐玄奘", "李玲玉"),
                Map.entry("白龙马", "龙女"));
        Map<String ,String> map=new HashMap<>(mapof);

        Map<String, String> toMap = map.entrySet().stream().filter(item -> !item.getValue().equals("无") )
                .collect(Collectors.toMap(item -> item.getKey(), item -> item.getValue()));
        System.out.println(toMap);

        //----------------------------简写lambda
        IntStream intStream = new Random().ints(1).map(Math::abs);
        intStream.forEach(System.out::println);
    }
}
