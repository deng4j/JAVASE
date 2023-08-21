package dzh.com.JavaSE.com.characteristic.throwable.tryCatchFinally;

import java.util.Scanner;

/**
 * 从try中哪条代码捕捉到异常，就会从哪条代码，
 * 跳过try直接运行catch代码。
 * 没有捕捉到异常不执行catch
 */
public class TC1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String s = scanner.nextLine();
        String s1 = scanner.nextLine();
        int result,i,j;
        try {
            i = Integer.parseInt(s);
            j = Integer.parseInt(s1);
            result=i+j;
        } catch (NumberFormatException e) {
            System.out.println("dasdasd");
            result=1;
        }
        System.out.println(result);
    }
}
