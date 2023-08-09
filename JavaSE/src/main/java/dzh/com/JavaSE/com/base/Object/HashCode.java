package dzh.com.JavaSE.com.base.Object;

public class HashCode {
    public static void main(String[] args) {
        m1();
    }

    private static void m1() {
        int[] a=new int[10];
        int[] b=new int[20];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a);
        System.out.println(b);
    }
}
