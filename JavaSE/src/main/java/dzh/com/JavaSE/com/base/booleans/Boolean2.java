package dzh.com.JavaSE.com.base.booleans;

public class Boolean2 {
    public static void main(String[] args) {
        boolean p1 = Boolean.parseBoolean("true");
        System.out.println(p1);

        boolean p2 = Boolean.parseBoolean("aaa");
        System.out.println(p2);

        Boolean v1 = Boolean.valueOf("true");
        System.out.println(v1);

        Boolean v2 = Boolean.valueOf("aa");
        System.out.println(v2);
    }
}
