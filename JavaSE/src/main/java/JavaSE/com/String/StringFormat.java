package JavaSE.com.String;

public class StringFormat {

    public static void main(String[] args) {
        m2();
    }

    private static void m2() {
        String format = String.format("%08d", 12);
        System.out.println(format);
    }

    private static void m1() {
        String url = "https://api.github.com/search/repositories?q=%s+language:%s&sort=stars&order=desc";
        url = String.format(url, "workflow", "java");
        System.out.println(url);
    }
}
