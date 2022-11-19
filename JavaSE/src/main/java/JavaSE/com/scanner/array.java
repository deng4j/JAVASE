package JavaSE.com.scanner;


import java.util.Scanner;

public class array {

    public static void main(String[] args) {


        System.out.println("输入一个数");
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int[] arr = new int[c];
        System.out.println("输入要查找的数");
        int k = scanner.nextInt();


        for (int i=0;i<arr.length;i++){
            int m= (int) Math.floor(Math.random()*10+1);
                    arr[i]=m;
                System.out.println(arr[i]);
        }
        int count=0;
        for (int p=0;p<arr.length;p++){

            if(arr[p]==k){
                count++;
                System.out.println("arr"+arr[p]);
            }

        }
        System.out.println(count+"次");


    }

}
