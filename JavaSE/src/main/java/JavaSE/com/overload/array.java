package JavaSE.com.overload;

public class array {
    public static void main(String[] args) {
        int[] arr={1,2,3,5,5};
        int[] newarr= get(arr);
        print(newarr);

    }

    public  static int[] get(int[] arr){
        int max=arr[0];
        int min=arr[0];
        for (int i=0;i<arr.length;i++){
            if (max<arr[i]){
                max=arr[i];
            }
            if (min>arr[i]){
                min=arr[i];
            }
        }
       int[] newarr={max,min};
        return newarr;
    }
    public static void print(int[] newarr){
        for (int i=0;i<newarr.length;i++){
            System.out.println(newarr[i]);
        }
    }
}
