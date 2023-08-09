package dzh.com.JavaSE.com.base.baseType.ints;

/**
 * int 数据类型是32位、有符号的以二进制补码表示的整数；
 * 最小值是 -2,147,483,648（-2^31）；
 * 最大值是 2,147,483,647（2^31 - 1）；
 * 默认值是 0 ；
 */
public class Int1 {
    public static void main(String[] args) {
        t5();
    }

    private static void t5() {
        int a = Integer.valueOf(2); //自动拆箱
        Integer b = 4; //自动装箱
    }

    private static void t4() {
        System.out.println("--------------------------------");
        /**
         * java中如果Integer不是new出Integer对象,而是直接赋值。
         * 会在常量池中开辟出同一个空间来缓存[-128,127]内的数字
         */
        System.out.println(Integer.valueOf(3) == Integer.valueOf(3));
        System.out.println(Integer.valueOf(277) == Integer.valueOf(277));
        System.out.println(new Integer(3) == new Integer(3));
    }

    private static void t3() {
        System.out.println("--------------------------------");
        Integer a = 222;
        Integer b = 222;
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

    private static void t2() {
        System.out.println("--------------------------------");
        Integer n1 = Integer.valueOf("001");
        System.out.println(n1);
    }

    private static void t1() {
        System.out.println("--------------------------------");
        int a = 0711_1111_123 & 15;
        System.out.println(a);
    }
}
