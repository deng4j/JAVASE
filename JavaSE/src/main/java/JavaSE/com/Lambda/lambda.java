package JavaSE.com.Lambda;

interface MathOperation{
    int operation(int a,int b);
}
public class lambda {
    //优化匿名内部类
    private  int operation(int a,int b,MathOperation m){
        return  m.operation(a, b);
    }

    public static void main(String[] args) {
        m1();
    }

    private static void m1() {
        lambda lambda=new lambda();
        MathOperation addtion=(a, b) -> a+b;
        boolean add=  lambda.operation(2,4,addtion)==lambda.operation(2,4,((a, b) -> a+b));
        System.out.println(add);
    }
}
