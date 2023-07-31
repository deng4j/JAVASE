package dzh.com.JavaSE.com.characteristic.overload;

/**
 * 方法的重载是指一个类中可以定义有相同的名字，但参数类型或数量不同的多个方法。
 */
public class Overload1 {
    public static void main(String[] args) {
        Overload1 overload1 = new Overload1();
        overload1.show(1);
        overload1.show(1,2);
        overload1.show(1,2L);
    }

    public void show(int a) {
        System.out.println("show(int a)：" + a);
    }

    public void show(int a, int b) {
        System.out.println("show(int a,int b)：" + a + b);
    }

    public void show(int a, long b) {
        System.out.println("show(int a,long b)：" + a + b);
    }
}
