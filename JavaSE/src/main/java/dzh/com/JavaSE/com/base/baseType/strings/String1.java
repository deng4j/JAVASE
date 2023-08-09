package dzh.com.JavaSE.com.base.baseType.strings;

/**
 * String 类是不可改变的，所以你一旦创建了 String 对象，那它的值就无法改变了。
 *
 * 如果有其他类型更适合，则尽量避免使用字符串。
 * 枚举类型比字符串更加适合用来表示枚举类型的常量。
 *
 * 字符串连接操作符"+"是把多个字符串合并为一个字符串。但不适合用于大规模场景中。
 * 为连接n个字符串而重复地使用连接操作符，需要n的平方级的时间。这是因为字符串对象是不可变对象。当两个字符串被连接时，它们的内容都要被拷贝。
 * 正确的做法是使用StringBuilder或者使用字符数组。
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
        String s3 = new String("aaaa"); // don't do this
        String s4 = new String("aaaa");
        System.out.println(s3==s4);
        System.out.println(s3.equals(s4));
    }

    private static void m1() {
        String s5 = "123\n456";
        System.out.println(s5);
    }
}
