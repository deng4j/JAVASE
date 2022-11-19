package JavaSE.com.String;

public class IsBlank_Empty {

    public static void main(String[] args) {
        m1();
    }

    /**
     * 不好用，会出现空指针，建议使用hutool工具
     */
    private static void m1() {
        String str=" ";
        boolean blank = str.isBlank();
        System.out.println(blank);

        String str2=" ";
        boolean empty = str2.isEmpty();
        System.out.println(empty);
    }
}
