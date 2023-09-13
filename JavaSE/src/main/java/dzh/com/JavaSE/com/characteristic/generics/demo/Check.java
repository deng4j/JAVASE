package dzh.com.JavaSE.com.characteristic.generics.demo;

import java.util.List;

public class Check<T> {
    /**
     * 非泛型方法
     */
    public T query(List<T> t){
        return t.get(0);
    }

    /**
     * 泛型方法，独立于方法
     */
    public <M> M query1(List<M> t){
        return t.get(0);
    }

    public static void main(String[] args) {
        Check<String> check =new Check<>();

        String query = check.query(List.of("1"));
        System.out.println(query);

        Integer query1 = check.query1(List.of(2));
        System.out.println(query1);
    }

}
