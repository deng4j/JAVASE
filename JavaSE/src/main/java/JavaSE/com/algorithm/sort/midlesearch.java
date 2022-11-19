package JavaSE.com.algorithm.sort;

public class midlesearch {
    public static void main(String[] args) {
        //二分查找法
        int[] arr={1,2,3,4,5,6,7,8,9};
        int a=9;
        int max=arr.length-1;
        int min=0;
        int index = (max+ min) / 2;
            while (min<=max) {
                if (a >=arr[min] && a<= arr[max]) {
                    if (a < arr[index]) {
                        max = index-1;
                        index = (max+ min) / 2;
                    } else if (a > arr[index]) {
                        min = index+1;
                        index = (max+ min) / 2;
                    }else if (a==arr[index]){
                        System.out.println(index);
                        break;
                    }

                }
            }

    }
}
