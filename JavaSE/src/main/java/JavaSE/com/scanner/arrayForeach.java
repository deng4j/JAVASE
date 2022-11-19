package JavaSE.com.scanner;

import java.util.Scanner;

public class arrayForeach {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("输入数组的长度");
        int len=scanner.nextInt();
        int[] arr=new int[len];
        System.out.println("输入数组元素");
        int count=0;
        for (int i=0;i<arr.length;i++){
            int item=scanner.nextInt();
            arr[i]=item;
            count+=arr[i];
        }
        System.out.println("总和："+count);

    }
}
