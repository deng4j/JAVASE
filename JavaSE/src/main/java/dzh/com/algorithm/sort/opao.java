package dzh.com.algorithm.sort;

import java.util.Arrays;

public class opao {
    public static void main(String[] args) {
        //冒泡排序法
        int[] arr={1,1,2,2,5,4,8,7,8,9};

        boolean sorted;
        //趟数
        for (int i = 0; i < arr.length-1; i++) {
            //次数，每次比较，后面的在前面已经比较过了，所以减去i,减少交换次数
            //假定交换过，sorted=true;
             sorted=true;
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    //没交换了
                    sorted=false;
                }
            }
            //减少交换趟数
            if (sorted==false){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
