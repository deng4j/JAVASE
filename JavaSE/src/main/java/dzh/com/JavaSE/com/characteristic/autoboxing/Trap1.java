package dzh.com.JavaSE.com.characteristic.autoboxing;

/**
 * java 1.5版本新特性，自动装箱
 * 允许程序员将基本类型和装箱基本类型混用
 *
 */
public class Trap1 {

    public static void main(String[] args) {
        tap3();
    }

    /**
     * 当一项操作中混合使用基本类型和装箱基本类型时，装箱基本类型会自动拆箱。如果null对象引用被自动拆箱，会得到一个空指针异常。
     * 而且反复的拆箱和装箱很影响性能。
     */
    private static void tap3() {
        Integer a = null;
        System.out.println(a+10);
    }

    /**
     * 装箱类型比较不应该使用"=="，应该使用equals
     */
    private static void trap2() {
        Integer a = 1000;
        Integer b = 1000;
        System.out.println(a==b);
        System.out.println(a.equals(b));
    }

    /**
     * 将sum声明为Long类型而不是long，意味着程序将构造2^31个多余的Long实例，要避免。
     * 所以要优先使用基本类型而不是装箱基本类型，要担心无意识的自动装箱。
     */
    private static void trap1() {
        long d1 = System.currentTimeMillis();
        Long sum = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum+=i;
        }
        long d2 = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println(d2-d1);

        System.out.println("----------------------");

        long d3 = System.currentTimeMillis();
        long sum1 = 0L;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum1+=i;
        }
        long d4 = System.currentTimeMillis();
        System.out.println(sum1);
        System.out.println(d4-d3);
    }
}
