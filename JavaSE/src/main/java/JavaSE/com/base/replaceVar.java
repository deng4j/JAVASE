package JavaSE.com.base;

public class replaceVar {

    public static void main(String[] args) {
        getodd(60,50);
    }
    private  static void getodd(int a,int b){
        //中间值互换变量
//        int m=0;
        if (a>b){
//            m=a;
//            a=b;
//            b=m;
            //异或运算变换
            a=a^b;
            b=b^a;
            a=a^b;
        }
        for (int i=a;i<b;i++){
            if (i%2==0){
                System.out.println(i);
            }
        }


    }
}
