package JavaSE.com.scanner;

import java.util.Scanner;

public class switch1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        while (true){
            int    sc=scanner.nextInt();
            switch (sc){
                case 1:
                    System.out.println(sc);
                    break;
                case 2:
                    System.out.println(sc);
                    break;
                 default:
                     break;
            }
        }
    }
}
