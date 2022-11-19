package JavaSE.com.String;

public class Substring {

    public static void main(String[] args) {
        m3();
    }

    private static void m3() {
        String str="t_table";
        String prefix="t_";
        String substring = str.substring(0,prefix.length());
        System.out.println(substring);
    }

    private static void m2() {
        String str="YS20221121001";
        String substring = str.substring(10);
        System.out.println(substring);
    }

    private static void m1() {
        String name="XH-YWXT:TEMPLATE:a3dedffd-db48-4629-a0bb-6fe69a8b4fab/4";
        int index = name.indexOf("/");
        String substring = name.substring(index+1);
        System.out.println(substring);
    }
}
