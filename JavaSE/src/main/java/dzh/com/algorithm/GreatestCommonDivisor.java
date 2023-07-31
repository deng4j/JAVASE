package dzh.com.algorithm;

public class GreatestCommonDivisor {

    public static void main(String[] args) {
        m();
    }

    //最大公约数与最小公倍数
    static void m() {
        long a = 12, b = 6, m, n, c;

        c = a * b;
        while (a > 0 && b > 0) {
            if (a > b) {
                a %= b;
            } else {
                b %= a;
            }
        }
        m = a > b ? a : b;
        n = c / m;
        System.out.println("最小公倍数：" + n + " 最大公约数：" + m);
    }
}
