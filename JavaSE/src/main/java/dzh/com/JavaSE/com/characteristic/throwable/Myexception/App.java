package dzh.com.JavaSE.com.characteristic.throwable.Myexception;

/**
 * Exception和Error都是Throwable的子类
 * <p>
 * 三种类型的异常：
 * 1.编译时异常：最具代表的检查性异常是用户错误或问题引起的异常，如IOException、SQLException。
 * 2.运行时异常：运行时异常是可能被程序员避免的异常。与检查性异常相反，运行时异常可以在编译时被忽略。
 * 3.错误： 错误不是异常，而是脱离程序员控制的问题。错误在代码中通常被忽略。例如，当栈溢出时，一个错误就发生了，它们在编译也检查不到的。
 * <p>
 * try...catch要捕获了正确的异常，try...catch才有意义，否则默认交给虚拟机处理
 * 出现多个异常写多个catch，用于区分异常处理结果
 * 多个异常有子父类关系，父类写下面，否则子类异常不会出现
 */
public class App {
    public int vag(int a, int b) throws Myexception {
        if (a < 0 || b < 0) {
            throw new Myexception("数字不能小于0");
        }
        if (a > 100 || b > 100) {
            throw new Myexception("数字不能大于100");
        }
        return (a + b) / 2;
    }

    public static void main(String[] args) {
        App app = new App();
        try {
            int a = app.vag(400, -10);
            System.out.println(a);
        } catch (Myexception myexception) {
            myexception.printStackTrace();
        }
    }
}
