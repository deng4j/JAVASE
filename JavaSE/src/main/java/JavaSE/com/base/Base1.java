package JavaSE.com.base;

public class Base1 {

    public static void main(String[] args) {

    }

    private static void logic() {
        //取反
        System.out.println("1取反："+~1);
        //2.异或,相同为0，不同为1
        System.out.println(1^1);
        System.out.println(0^0);
        System.out.println(0^1);
        System.out.println(1^0);
        System.out.println(-1^0);
        //异或的本质：异或也叫半加运算，其运算法则相当于不带进位的二进制加法
        /**
         * 1 ^ 1 == 0
         *   0001
         *   0001
         * > 0010
         *
         * 1 ^ 0 == 1
         *   0001
         *   0000
         * > 0001
         */
        boolean flag1=2>1 || 1/0>1;
        boolean flag2=2<1 && 1/0>1;
        System.out.println(flag1);
        System.out.println(flag2);
    }

    private static void mod() {
        System.out.println("1%5："+(1%5));
        System.out.println("6%5："+(6%5));
    }

    /**
     * ++操作
     */
    private static void increment() {
        int i=0;
        int[] arr=new int[]{1,2,3,4};
        System.out.println("先得到i："+arr[i++]);
        i=0;
        System.out.println("先i加1："+arr[++i]);
        //---------------------------
        i=0;
        System.out.println(i++);
        i=0;
        System.out.println(++i);
    }

    /**
     * 位运算
     */
    private static void bit_operation() {
        System.out.println("1左移3位：" + (1 << 3));
        System.out.println("-1左移2位：" + (-1<<2));
        System.out.println("无符号右移2位"+ (-16>>>2));

    }

    /**
     * 求绝对值
     */
    int abs(int a) {
        int i = a >> 31;
        return i == 0 ? a : (~a + 1);
    }
}
