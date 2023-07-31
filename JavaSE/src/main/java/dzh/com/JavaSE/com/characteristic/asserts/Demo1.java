package dzh.com.JavaSE.com.characteristic.asserts;

/**
 * 需要在jvm中加参数 -ea
 */
public class Demo1 {

    public static void main(String[] args) {
        try {
            m2();
        } catch (Exception e) {
            System.out.println("catch e");
        }
    }

    private static void m2() {
        assert false;
    }

    private static void m1() {
        assert false : "exception";
    }
}
