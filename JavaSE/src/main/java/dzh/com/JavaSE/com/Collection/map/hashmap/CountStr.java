package dzh.com.JavaSE.com.Collection.map.hashmap;

import java.util.HashMap;
import java.util.Map;

public class CountStr {
    public static void main(String[] args) {
        String str="If you want to change your fate I think you must come to the dark horse to learn java";
        String[] arrstr = str.split(" ");
        Map<String,Integer> map=new HashMap<>();
        for (int i = 0; i < arrstr.length; i++) {
            if (map.containsKey(arrstr[i])){
                map.put(arrstr[i],map.get(arrstr[i])+1);
            }else {
                map.put(arrstr[i],1);
            }
        }
        System.out.println(map);


    }

}
