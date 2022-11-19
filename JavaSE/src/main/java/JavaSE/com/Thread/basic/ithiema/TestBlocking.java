package JavaSE.com.Thread.basic.ithiema;

import java.util.Scanner;

public class TestBlocking {

    public static void main(String[] args) {
        System.out.println("start...");
        new Thread(()->{
            Scanner scanner = new Scanner(System.in);
            while (true){
                String line = scanner.nextLine();
                if ("q".equals(line)){
                    break;
                }
                System.out.println(line);
            }
        },"Thread-1").start();
        //这里不会被阻塞住
        System.out.println("end...");
    }
}
