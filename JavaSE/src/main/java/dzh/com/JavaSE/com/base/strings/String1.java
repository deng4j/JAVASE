package dzh.com.JavaSE.com.base.strings;

/**
 * String 类是不可改变的，所以你一旦创建了 String 对象，那它的值就无法改变了。
 */
public class String1 {
    public static void main(String[] args) {
    }

    private static void m() {
        // 静态创建字符串，放在常量池中
        String s1 = "aaaa";
        String s2 = "aaaa";
        System.out.println(s2==s1);
        System.out.println(s2.equals(s1));

        // 动态创建，在堆中
        String s3 = new String("aaaa");
        String s4 = new String("aaaa");
        System.out.println(s3==s4);
        System.out.println(s3.equals(s4));
    }

    private static void m1() {
        String s5 = "123\n456";
        System.out.println(s5);
    }
}
