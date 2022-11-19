package JavaSE.com.overload;

public class arr {
    public static void main(String[] args) {
        int[] arr={6,5,4,3,2,1};

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

        for (int i:arr) {
            System.out.println(i);
        }
    }
}
