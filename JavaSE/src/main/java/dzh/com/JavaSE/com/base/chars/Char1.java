package dzh.com.JavaSE.com.base.chars;

/**
 * char 类型是一个单一的 16 位 Unicode 字符；
 * 最小值是 \u0000（十进制等效值为 0）；
 * 最大值是 \uffff（即为 65535）；
 * char 数据类型可以储存任何字符；
 */
public class Char1 {
    public static void main(String[] args) {
        char a = 'a';
        System.out.println(a);
        System.out.println((int)a);


        Character c1 = 'c'; // 自动装箱
        char c2 = Character.valueOf('c'); // 自动拆箱
        System.out.println(c1+"-----"+c2);
    }
}
