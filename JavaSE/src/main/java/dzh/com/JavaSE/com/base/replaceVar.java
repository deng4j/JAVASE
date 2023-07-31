package dzh.com.JavaSE.com.base;

public class replaceVar {

    public static void main(String[] args) {
        getodd(60, 50);
        useXOR(60, 50);
    }

    public static void useXOR(int a, int b) {
        //异或运算变换
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.println(a + "----" + b);
    }

    private static void getodd(int a, int b) {
        //中间值互换变量
        int m=0;
        if (a > b) {
            m=a;
            a=b;
            b=m;
        }
        System.out.println(a + "----" + b);
    }
}
