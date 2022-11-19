package JavaSE.com.exception.asserts;

/**
 * 需要在jvm中加参数 -ea
 */
public class Demo1 {

    public static void main(String[] args) {
        m2();
    }

    private static void m2() {
        assert false;
    }

    private static void m1() {
        assert false : "exception";
    }
}
