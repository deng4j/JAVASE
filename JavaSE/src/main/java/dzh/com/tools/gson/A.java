package dzh.com.tools.gson;

import com.google.gson.reflect.TypeToken;

/**
 * 获取泛型具体类型
 * @param <T>
 */
public class A <T>{

    private String getType() {
        TypeToken<A<T>> typeToken= new TypeToken<>(){};
        return typeToken.getType().getTypeName();
    }

    public static void main(String[] args) {
        TypeToken<A<Integer>> typeToken= new TypeToken<>(){};
        System.out.println(typeToken.getType());

        A<Integer> a =new A<>(){};
        System.out.println(a.getType());
    }
}
