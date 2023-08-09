package dzh.com.JavaSE.com.base;

public class Operator {

    public static void main(String[] args) {
        increment();
    }

    /**
     * 异或的本质：异或也叫半加运算，其运算法则相当于不带进位的二进制加法
     * <p>
     * 1 ^ 1 == 0
     * 0001
     * 0001
     * > 0010
     * <p>
     * 1 ^ 0 == 1
     * 0001
     * 0000
     * > 0001
     */
    private static void XOR() {
        //异或,相同为0，不同为1
        System.out.println(1 ^ 1);
        System.out.println(0 ^ 0);
        System.out.println(0 ^ 1);
        System.out.println(1 ^ 0);
        System.out.println(-1 ^ 0);
    }

    private static void XOR1() {
        int a =1;
        int b =2;
        //异或运算交换变量
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println(a + "----" + b);
    }


    /**
     * ||和//有断路作用，当可以从前一个结果得出整个结果时，无需再运行后面的判断
     */
    private static void andOr() {
        try {
            System.out.println(2 > 1 | 1 / 0 > 1);
            System.out.println(2 < 1 & 1 / 0 > 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean flag1 = 2 > 1 || 1 / 0 > 1;
        boolean flag2 = 2 < 1 && 1 / 0 > 1;
        System.out.println(flag1);
        System.out.println(flag2);
    }

    private static void negation() {
        //取反
        System.out.println("1取反：" + ~1);
    }

    private static void mod() {
        System.out.println("1%5：" + (1 % 5));
        System.out.println("6%5：" + (6 % 5));
    }

    /**
     * ++/--操作
     */
    private static void increment() {
        int i = 0;
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println("先得到i：" + arr[i++]);
        i = 0;
        System.out.println("先i加1：" + arr[++i]);
        //---------------------------
        i = 0;
        System.out.println(i++);
        i = 0;
        System.out.println(++i);
    }

    /**
     * 位运算
     */
    private static void bit_operation() {
        System.out.println("1左移3位：" + (1 << 3));
        System.out.println("-1左移2位：" + (-1 << 2));
        System.out.println("无符号右移2位" + (-16 >>> 2));

    }

    /**
     * 求绝对值
     */
    int abs(int a) {
        int i = a >> 31;
        return i == 0 ? a : (~a + 1);
    }
}
