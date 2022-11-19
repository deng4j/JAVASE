package JavaSE.com.scanner;

public class String3 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i <arr.length ; i++) {
            if (i==0){
                stringBuffer.append("<"+arr[i]);
            }else if (i>0&&i<arr.length-1){
                stringBuffer.append(arr[i]);
            }else {
                stringBuffer.append(arr[i]+">");
            }
        }
        System.out.println(stringBuffer);
    }
}
