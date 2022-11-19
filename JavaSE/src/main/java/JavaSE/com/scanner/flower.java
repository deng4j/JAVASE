package JavaSE.com.scanner;

import java.util.Random;
import java.util.Scanner;

public class flower {
    public static void main(String[] args) {
        Random r=new Random();
        int a=r.nextInt(100)+1;

        Scanner scanner=new Scanner(System.in);
        int count=0;
        while (true){
            int s=scanner.nextInt();
            count++;
            if (s>a){
                System.out.println("猜大了");
            }else if (s<a){
                System.out.println("猜小了");
            }else {
                System.out.println("猜对了");
                break;
            }
        }
        System.out.println("用了"+count+"次");


    }
}
