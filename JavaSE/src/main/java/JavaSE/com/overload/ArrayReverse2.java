package JavaSE.com.overload;

import java.util.Scanner;

public class ArrayReverse2 {
    public static void main(String[] args) {
        set();
    }

    public static void set(){
        int[] arr=new int[6];
        Scanner scanner=new Scanner(System.in);
        for (int i=0;i<arr.length;i++){
            System.out.println("输入第"+(i+1)+"个数");
            int sc=scanner.nextInt();
            arr[i]=sc;
        }
            reverse(arr);
            ret(arr);
            rre(arr);
        for (int i:
            arr ) {
            System.out.println(i);
        }
    }
    public static int[] reverse(int[] arr){
        int start=0;
        int end=arr.length-1;
        while (start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        return arr;
    }

    public static  int[] ret(int[] arr){
        for (int i=0;i<arr.length;i++){
            if (i%2!=0){
                for (int k=0; k<arr.length;k++){
                    int p;
                    if (k-i==2){
                        p=arr[i];
                        arr[i]=arr[k];
                        arr[k]=p;
                        p++;
                    }
                }

            }
        }
        //634125
        return arr;
    }
    public static int[] rre(int[] arr){
        for (int i=0;i<arr.length;i++){
            for (int k=0;k<arr.length;k++){
                if (i%2!=0){
                    if (k-i>=arr.length-2){
                        int temp=arr[1];
                        arr[1]=arr[k];
                        arr[k]=temp;
                    }
                }
            }
        }
        return arr;
    }
}
