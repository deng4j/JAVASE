package dzh.com.JavaSE.com.base.bytes;

/**
 * byte 数据类型是8位、有符号的，以二进制补码表示的整数；
 * 最小值是 -128（-2^7）；
 * 最大值是 127（2^7-1）；
 * 默认值是 0；
 * byte 类型用在大型数组中节约空间，主要代替整数，因为 byte 变量占用的空间只有 int 类型的四分之一；
 */
public class Byte1 {
    public static void main(String[] args) {
        byte b1 = 100;
        byte b2 = 100;
        System.out.println(b1==b2);

        byte b3 = Byte.valueOf("10"); // 自动拆箱
        Byte b4 = 12; // 自动装箱
        System.out.println(b3==b4);
    }
}
