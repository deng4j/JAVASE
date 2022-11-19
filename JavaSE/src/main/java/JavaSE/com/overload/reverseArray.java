package JavaSE.com.overload;

public class reverseArray {
    public static void main(String[] args) {
        //数组倒置
        int[] arr={1,2,3,4,5,6,};
        //1.使用第二个数组倒置
        /*int[] newarr=new int[arr.length];
        int k=0;
        for (int i=arr.length-1;i>=0;i--){
                if (k<arr.length){
                    newarr[k]=arr[i];
                    k++;
                }
        }

        for (int h:newarr ) {
            System.out.println(h);
        }*/
        //2.使用指针交换
        int start=0;
        int end=arr.length-1;
        while (start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }

        for (int h:arr ) {
            System.out.println(h);
        }

    }
}
