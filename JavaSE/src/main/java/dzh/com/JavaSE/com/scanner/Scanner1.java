package dzh.com.JavaSE.com.scanner;

import java.util.Scanner;

/**
 * Scanner是一个扫描器，我们录取到键盘的数据，先存到缓存区等待读取，它判断读取结束的标示是  空白符；比如空格，回车，tab 等等。
 *
 * next()方法读取到空白符就结束；
 * nextLine()读取到回车结束也就是“\r”；
 */
public class Scanner1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2=scanner.nextLine();
        System.out.println(s1);
        System.out.println(s2);
    }

    private static void m1() {
        Scanner scanner=new Scanner(System.in);
        String s1=scanner.next();
        String s2=scanner.next();
        System.out.println(s1);
        System.out.println(s2);
    }
}
