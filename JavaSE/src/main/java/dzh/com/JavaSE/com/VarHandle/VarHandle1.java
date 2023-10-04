package dzh.com.JavaSE.com.VarHandle;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * VarHandle用于操作类的成员变量以及提供一些原子的操作。
 * 用于替换UnSafe类，因为UnSafe太过危险。
 * 比反射效率高出不少。
 */
public class VarHandle1 {
    int a = 8;
    int b = 1;
    private static VarHandle A;
    private static VarHandle B;

    static {
        try {
            A = MethodHandles.lookup().findVarHandle(VarHandle1.class, "a", int.class);
            B = MethodHandles.lookup().findVarHandle(VarHandle1.class, "b", int.class);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VarHandle1 varhand = new VarHandle1();

        System.out.println(A.get(varhand)); // 获取变量a

        A.set(varhand,10); // 设置变量a
        System.out.println(varhand.a);

        A.compareAndSet(varhand,10,11); //CAS操作
        System.out.println(varhand.a);

        System.out.println("------------------------");

        System.out.println(B.get(varhand));
    }
}
