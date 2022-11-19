package JavaSE.com.String;

public class repeat {

    public static void main(String[] args) {
        m1();
    }

    private static void m1() {
        String str = "HELLO";

        String empty = str.repeat(0);
        System.out.println(empty);

        String repeatOne = str.repeat(1);
        System.out.println(repeatOne);

        String repeatTwo = str.repeat(2);
        System.out.println(repeatTwo);
    }
}
