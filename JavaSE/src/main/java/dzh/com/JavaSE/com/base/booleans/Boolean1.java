package dzh.com.JavaSE.com.base.booleans;

/**
 * boolean数据类型表示一位的信息；
 * 只有两个取值：true 和 false；
 * 这种类型只作为一种标志来记录 true/false 情况；
 * 默认值是 false；
 */
public class Boolean1 {
    public static void main(String[] args) {
        boolean a = Boolean.TRUE; // 自动拆箱
        Boolean b = true; // 自动装箱
        System.out.println(a == b);
    }
}
