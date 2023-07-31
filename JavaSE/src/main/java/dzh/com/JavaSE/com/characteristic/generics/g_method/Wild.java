package dzh.com.JavaSE.com.characteristic.generics.g_method;

import java.util.ArrayList;

/**
 * 通配符
 * ?类型不定，使用时确定类型
 * ?使用:声明类型|声明方法上，不能声明类或使用时
 * ? extends : <= 上限  指定类型 子类或自身
 * ? super :>=下限   指定类型 为自身或父类
 */
public class Wild<T> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    /**
     * 通配符表示不确定的类型
     */
    private static void printArr(ArrayList<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    /**
     * 通配符继承了number，可以接收number和它的子类
     */
    private static void extendsArr(ArrayList<? extends Number> list) {
    }

    /**
     * 通配符继承了number，可以接收number和它的超类
     */
    private static void superArr(ArrayList<? super Number> list) {
    }

    /**
     * 这也不是一个泛型方法，这也是一个普通的方法，只不过使用了泛型通配符?
     *
     */
    public void showKeyValue2(Wild<?> obj) {
        System.out.println("泛型测试 key value is " + obj.getKey());
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("2");
        printArr(list1);
        printArr(list2);

        extendsArr(list1);
    }
}
