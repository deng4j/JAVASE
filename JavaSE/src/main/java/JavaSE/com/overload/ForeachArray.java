package JavaSE.com.overload;

public class ForeachArray {
    public static void main(String[] args) {
        Object[] arr={'a',1,2};
        foreach(arr);

    }
    public static  void foreach(Object[] arr){
        System.out.print("[");
        for (int i=0;i<arr.length;i++){
            if (arr.length-1==i){
                System.out.print(arr[i]+"]");
            }else
            System.out.print(arr[i]+",");

        }



    }
}
