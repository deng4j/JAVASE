package JavaSE.com.algorithm;

public class XOR_exchange_variable {

    public static void main(String[] args) {
        m1();
    }

    /**
     * 异或交换变量
     */
    private static void m1() {
        int a = 1;
        int b = 2;

        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a+"--"+b);
    }
}
