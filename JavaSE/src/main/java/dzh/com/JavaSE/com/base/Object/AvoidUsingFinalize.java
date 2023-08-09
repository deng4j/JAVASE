package dzh.com.JavaSE.com.base.Object;

/**
 * finalize()方法是Object类中提供的一个方法，在GC准备释放对象所占用的内存空间之前，它将首先调用finalize()方法。
 * 在Java中，由于GC的自动回收机制，因而并不能保证finalize方法会被及时地执行（垃圾对象的回收时机具有不确定性），也不能保证它们会被执行(程序由始至终都未触发垃圾回收)。
 * finalize()方法中一般用于释放非Java 资源（如打开的文件资源、数据库连接等）,或是调用非Java方法（native方法）时分配的内存（比如C语言的malloc()系列函数）。
 *
 * 避免使用终结方法finalize，通常是不可预测的，也是很危险的，一般情况下是不必要的。
 * 使用终结方法会导致不稳定，性能降低，以及移植性问题。
 */
public class AvoidUsingFinalize {

    private static int a = 10;
    private int b = 20;

    public static void main(String[] args) throws Throwable {
        AvoidUsingFinalize avoidUsingFinalize = new AvoidUsingFinalize();
        avoidUsingFinalize.finalize();
        System.out.println(avoidUsingFinalize.b);
        System.out.println(AvoidUsingFinalize.a);
    }
}
