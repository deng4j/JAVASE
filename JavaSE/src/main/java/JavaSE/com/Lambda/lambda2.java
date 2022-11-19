package JavaSE.com.Lambda;

interface  inter{
    void show();
}
interface  inter2{
    void  show(int a,int b);
}

interface  inter3{
    int show(int a,int b);
}

interface inter4{
    int show(int a,int b);
}

/**
 * 接口的多态
 * 接口的实现类对象重写接口方法
 */

public class lambda2 {
    public static int operation(int a,int b,inter4 i){
        return i.show(a, b);
    }
    public static void main(String[] args) {
        inter in1= ()->{
            System.out.println("i love you");
        };
        in1.show();
        //-------------------------------
        inter2 in2=(a,b)->{
            System.out.println(a+b);
        };
        in2.show(10,20);
        //------------------------------
        inter3 in3=(a,b)->{
            return a+b;
        };
         int inadd= in3.show(10,20);
        System.out.println(inadd);
        //--------------------------------
        inter4 addtion=(a, b) -> a+b;
        inter4 substract=((a, b) -> a-b);
        int  in4= operation(4,5,addtion);
        System.out.println(in4);
    }

}
