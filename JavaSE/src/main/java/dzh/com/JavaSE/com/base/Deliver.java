package dzh.com.JavaSE.com.base;

import java.util.ArrayList;
import java.util.List;

/**
 * 引用传递和值传递
 */
public class Deliver {

    private int b=10;

    public static void main (String[] args){
        System.out.println("------------测试数组---------");
        List<String> a = new ArrayList<>();
        a.add("222");
        test(a);
        System.out.println("main:："+a);

        try {
            List<String> aa=null;
            test(aa);
            System.out.println("size:"+aa.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //-------------------------------------------------------------------
        System.out.println("--------------测试传递值-------------------");
        Deliver test1 = new Deliver();
        test1(test1.b);
        System.out.println("传递值main:"+test1.b);

        test2(test1);
        System.out.println("传递引用后main："+test1.b);


    }

    /**
     * 传递的是null，那就是值传递，不是引用传递
     * @param a
     */
    public static void test(List<String> a){
        a=new ArrayList<>();
        a.add("111");
    }

    /**
     * 测试传递值
     * @param a
     */
    public static void test1(int a){
        a=555;
    }

    /**
     * 测试传递引用
     */
    public static void test2(Deliver test1){
        test1.b=500;
    }


}


