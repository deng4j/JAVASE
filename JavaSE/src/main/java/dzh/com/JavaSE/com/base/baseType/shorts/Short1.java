package dzh.com.JavaSE.com.base.baseType.shorts;

/**
 * short 数据类型是 16 位、有符号的以二进制补码表示的整数
 * 最小值是 -32768（-2^15）；
 * 最大值是 32767（2^15 - 1）；
 * Short 数据类型也可以像 byte 那样节省空间。一个short变量是int型变量所占空间的二分之一；
 * 默认值是 0；
 */
public class Short1 {
    public static void main(String[] args) {
        short s1 = 10;
        short s2 = 10;
        System.out.println(s1==s2);

        Short s3 = 20; // 自动装箱
        short s4 = Short.valueOf("10"); // 自动拆箱
        System.out.println(s3==s4);
    }
}
