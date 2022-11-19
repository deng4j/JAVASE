package JavaSE.com.Reflect.reflect1;

/**
 * 查看class类介绍可知
 */
public class demo {
    public static void main(String[] args) {
        int[] a=new int[10];
        int[] b=new int[20];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());
        System.out.println(a);
        System.out.println(b);
    }
}
