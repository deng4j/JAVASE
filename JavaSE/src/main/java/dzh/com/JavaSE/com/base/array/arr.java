package dzh.com.JavaSE.com.base.array;

public class arr {
    public static void main(String[] args) {
        int[] arr1={1,2,3};
        int[] arr2=new int[10];
        int[] arr3=new int[]{1,2,3};
        int[][] arr4=new int[2][3];

        int arr5[]={1,2};
        arrString(arr5);
    }

    public static void arrString(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
