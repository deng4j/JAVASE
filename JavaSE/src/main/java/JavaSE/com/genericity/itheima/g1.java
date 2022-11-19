package JavaSE.com.genericity.itheima;

import java.util.ArrayList;
import java.util.List;

public class g1 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("泰迪");

        String a1 = add(list);
        System.out.println(a1);
    }

    /**
     *定义泛型方法时的<>尖括号里面的泛型类型可以是泛型列表，中间用“，”号隔开，这一点与泛型接口和泛型类雷同
     */
    public  static <T> T add(List<T> list){
        T t1 = list.get(0);
        return t1;
    }
}
