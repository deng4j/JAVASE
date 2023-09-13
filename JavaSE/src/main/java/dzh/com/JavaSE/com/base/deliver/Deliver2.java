package dzh.com.JavaSE.com.base.deliver;

/**
 * 值传递
 */
public class Deliver2 {

    private static int b = 2;

    public static void main (String[] args){
        int a = 1;
        transfer(a);
        System.out.println(a);

        System.out.println("----------------------");
        transfer(b);
        System.out.println(b);

        System.out.println("------------------------");
        String s = "111";
        transfer(s);
        System.out.println(s);
    }

    public static void transfer(int a){
        a = 10;
    }

    public static void transfer(String str){
        str = "ss";
    }

}


