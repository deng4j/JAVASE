package JavaSE.com.Collection.map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class PutAllTest {
    public static void main(String[] args) {
        Map<String, String> map = Map.of("k1", "v1", "k2", "v2");
        Map<String,String> stringMap=new HashMap<>(16);
        stringMap.putAll(map);
        System.out.println(stringMap);
    }
}
