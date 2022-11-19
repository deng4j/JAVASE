package JavaSE.com.algorithm.sort;

public class fast {
    public static void main(String[] args) {
        int[] arr={6,1,4,2,8,9,5,7};
        
        quiksort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }


    private static void quiksort(int[] arr, int left, int right) {
        if (left>right){
            return;
        }
        //保存临时
        int left0=left;
        int right0=right;
        //基准数
        int base=arr[left0];
        while (left!=right){
            while (arr[right]>=base&&left<right){
                right--;
            }
            while (arr[left]<=base&&left<right){
                left++;
            }

            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
        }
        int temp=arr[left];
        arr[left]=arr[left0];
        arr[left0] =temp;
        quiksort(arr,left0,left-1);
        quiksort(arr,left+1,right0);

    }




}
