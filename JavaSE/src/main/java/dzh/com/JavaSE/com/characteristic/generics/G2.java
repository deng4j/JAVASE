package dzh.com.JavaSE.com.characteristic.generics;

/**
 * 编译期，确定类型
 */
public class G2<T> {

    public G2<T> show(T t){
        System.out.println(t.getClass().getName());
        return this;
    }

    public static void main(String[] args) {
        // 在句柄中确定类型
        G2<Boolean> a = new G2<>();
        a.show(true);

        // 在实例中确定类型
        G2<Object> show = new G2<>().show(1); // Object类型

        new G2<String>().show("111"); // String类型
    }
}
