package dzh.com.JavaSE.com.base.strings;

public class ValueOf {

    public static void main(String[] args) {
        // String value = String.valueOf(null); //空指针异常

        String v1 = String.valueOf(123);
        System.out.println(v1);

        String v2 = String.valueOf(true);
        System.out.println(v2);
    }
}
