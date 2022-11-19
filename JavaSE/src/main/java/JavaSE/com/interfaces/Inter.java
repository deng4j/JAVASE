package JavaSE.com.interfaces;

/**
 * 接口中的成员方法默认是public  abstract的
 * 接口中的成员变量和类默认是public static final
 */
public interface Inter {

    int a=10;

    void show();

    public default void show2(){
        System.out.println("默认方法体");
    }
    public static void show3(){
        System.out.println("静态方法体");
    }
    private static void show4(){
        System.out.println("接口的私有方法");
    }

}