package dzh.com.JavaSE.com.base.baseType.longs;

/**
 * long 数据类型是 64 位、有符号的以二进制补码表示的整数；
 * 最小值是 -9,223,372,036,854,775,808（-2^63）；
 * 最大值是 9,223,372,036,854,775,807（2^63 -1）；
 * 默认值是 0L；
 */
public class Long1 {
    public static void main(String[] args) {
        long a1 = 123;
        long a2 = 123L;
        long a3 = 123l;
        System.out.println(a1==a2);
        System.out.println(a2==a3);

        Long a4 = 123L; // 自动装箱
        long a5 = Long.valueOf(123); // 自动拆箱
        System.out.println(a4==a5);
    }
}
