package JavaSE.com.arrays;

public class arr {

    static int arr[]={1,2,3};

    public static void main(String[] args) {
        int[] arr1={1,2,3};
        int[] arr2=new int[10];
        int[]  arr3=new int[]{1,2,3};

        int arr4[]={1,2};
        arrString(arr4);

        int[][] arr22=new int[2][3];
    }

    public static void arrString(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
