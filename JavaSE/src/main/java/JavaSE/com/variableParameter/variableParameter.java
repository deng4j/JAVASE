package JavaSE.com.variableParameter;

/**
 * 可变参数是一个数组
 */
public class variableParameter {
    public static void main(String[] args) {
        int[] arr=new int[]{12,15,45,43};
        int sum = getsunm("求和", arr);
        getsunm("求和",12,13,13,13);
        System.out.println(sum);

    }
    public static int getsunm(String str,int... arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum;
    }
}
