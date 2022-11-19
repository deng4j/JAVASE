package JavaSE.com.genericity.itheima;

import java.util.ArrayList;

public class wildcard {
    public static void main(String[] args) {
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(1);
        ArrayList<String> list2=new ArrayList<>();
        list2.add("2");
        printArr(list1);
        printArr(list2);

        extendsArr(list1);
    }

    //通配符表示不确定的类型
    private static void printArr(ArrayList<?> list){
        for (Object o: list) {
            System.out.println(o);
        }
    }
    //通配符继承了number，可以接收number和它的子类
    private static void extendsArr(ArrayList<? extends Number> list){
    }
    //通配符继承了number，可以接收number和它的超类
    private static void superArr(ArrayList<? super Number> list){
    }
}
