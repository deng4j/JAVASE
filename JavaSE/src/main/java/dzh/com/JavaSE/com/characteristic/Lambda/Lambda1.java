package dzh.com.JavaSE.com.characteristic.Lambda;

@FunctionalInterface
interface MathOperation{
    int operation(int a,int b);
}

/**
 * Java 8 新特性
 * Lambda 表达式 − Lambda 允许把函数作为一个方法的参数（函数作为参数传递到方法中）
 * lambda表达式只能用于函数式接口(只有一个抽象方法的接口)。
 * Lambda 表达式免去了使用匿名方法的麻烦，并且给予 Java 简单但是强大的函数化的编程能力。
 * lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。
 */
public class Lambda1 {
    /**
     * 优化匿名内部类
     */
    private  int operation(int a,int b,MathOperation m){
        return  m.operation(a, b);
    }

    public static void main(String[] args) {
        m1();
    }

    private static void m1() {
        Lambda1 lambda=new Lambda1();
        MathOperation addtion=(a, b) -> a+b;
        boolean add=  lambda.operation(2,4,addtion)==lambda.operation(2,4,((a, b) -> a+b));
        System.out.println(add);
    }
}
