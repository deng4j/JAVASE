package dzh.com.JavaSE.com.characteristic.Lambda;

interface  F1{
    void show();
}
interface  F2{
    void  show(int a,int b);
}

interface  F3{
    int show(int a,int b);
}

interface F4{
    int show(int a,int b);
}


public class Lambda2 {
    public static int operation(int a,int b,F4 f){
        return f.show(a, b);
    }
    public static void main(String[] args) {
        F1 f1= ()->{
            System.out.println("i love you");
        };
        f1.show();
        //-------------------------------
        F2 f2=(a,b)->{
            System.out.println(a+b);
        };
        f2.show(10,20);
        //------------------------------
        F3 f3=(a,b)->{
            return a+b;
        };
        int i3= f3.show(10,20);
        System.out.println(i3);
        //--------------------------------
        F4 addtion=(a, b) -> a+b;
        F4 substract=((a, b) -> a-b);
        int  in4= operation(4,5,addtion);
        System.out.println(in4);
    }

}
