package dzh.com.algorithm.sort;


public class Greedy {
    public static void main(String[] args) {

        int[] arr={3,2,7,4,3,1,9,78979,4564,87,4,5,6,2,8,5};

        //贪心算法,index记录下标去过最远的地方
        int index=1;
        for (int i = 1; i < arr.length; ) {
            if (i>0&&arr[i-1]>arr[i]){
                int temp=arr[i];
                arr[i]=arr[i-1];
                arr[i-1]=temp;
                i--;
            }else {
                if (i<index){
                    i=index;
                }else {
                    index=i;
                }
                i++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
