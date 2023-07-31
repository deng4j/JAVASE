package dzh.com.JavaSE.com.Collection.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * 数组+链表/红黑树
 * 默认长度16，0.75后扩容2倍
 * 产生hash冲突，会形成链表
 * 当链表长度大于8，table表长度小于64时，每次添加元素，table扩容。
 * 当链表长度大于8，table表长度大于64时，时转成红黑树
 * 当不满足红黑树条件，还会退化成链表
 */
public class hashmap1 {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("a","101");
        map.put("97",null);
        map.put("b",null);
        map.put("a","100");
        map.put("d","100");
        map.put(null,"101");
        System.out.println(map);

        System.out.println(map.get("xx"));

        map.remove(null);
        System.out.println(map);
        
        boolean f1 = map.containsKey("a");
        boolean f2 = map.containsValue(null);
        boolean f3 = map.isEmpty();
        System.out.println(f1+" "+f2+" "+f3);

        //遍历集合
        System.out.println("------------keyset--------------");
        Set<String> keys = map.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            String key=iterator.next();
            String value = map.get(key);
            System.out.println(key+":"+value);
        }

        System.out.println("------------entry--------------");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Iterator<Map.Entry<String,String>> iterator1=entries.iterator();
        while (iterator1.hasNext()){
            Map.Entry<String,String> maps=iterator1.next();
//            System.out.println(maps.getKey());
//            System.out.println(maps.getValue());
            System.out.println(maps);
        }

        System.out.println("------------stream--------------");
        map.entrySet().stream().forEach(kv -> {
            System.out.println("K:"+kv.getKey()+"-----"+kv.getValue());
        });

        System.out.println("------------foreach--------------");
        BiConsumer<String,String> biConsumer=(String key,String value )->{
            System.out.println(key+"="+value);
        };
        map.forEach(biConsumer);

    }
}
