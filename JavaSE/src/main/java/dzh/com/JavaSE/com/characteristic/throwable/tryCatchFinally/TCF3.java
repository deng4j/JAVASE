package dzh.com.JavaSE.com.characteristic.throwable.tryCatchFinally;

public class TCF3 {
    public static void main(String[] args) {
        System.out.println(m2());
    }

    private static int m1() {
        int a;
        try {
            a = 1/0;
        } catch (Exception e) {
            a = 10;
            System.out.println("catch"+a);
            return a; // 在这里就会返回了，尽管finally会运行
        } finally {
            a = 20;
            System.out.println("finally"+a);
        }
        return a;
    }

    private static int m2() {
        int a;
        try {
            a = 1/0;
        } catch (Exception e) {
            a = 10;
            System.out.println("catch"+a);
            return a;
        } finally {
            a = 20;
            return a; // 在这里就会返回了
        }
    }
}
