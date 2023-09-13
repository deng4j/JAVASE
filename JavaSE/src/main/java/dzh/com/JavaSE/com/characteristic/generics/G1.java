package dzh.com.JavaSE.com.characteristic.generics;

/**
 * 泛型（generics）是 JDK 5 中引入的一个新特性, 泛型提供了编译时类型安全检测机制，该机制允许程序员在编译时检测到非法的类型。
 * 泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。
 *
 * 泛型只能使用引用类型，不能基本类型
 *
 * java 中泛型标记符：
 *  E - Element (在集合中使用，因为集合中存放的是元素)
 *  T - Type（Java 类）
 *  K - Key（键）
 *  V - Value（值）
 *  N - Number（数值类型）
 *  ？ - 表示不确定的 java 类型
 *
 * 泛型没有多态，声明了什么类型，传入的参数就必须是该类型，不能是他的子类
 *
 * 在运行期只能获取当前class文件中包含泛型信息的泛型类型，而不能在运行时动态获取某个泛型引用的类型。
 * 泛型的类型擦除是指把某个具体的泛型引用在编译期完成类型检查后，擦除成了Object而丢失了它运行时所赋予的类型信息。
 */
public class G1<T> {
    private  T a;

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        //自动装箱
        G1<Boolean> g1=new G1();
        g1.setA(true);

        G1<Integer> g2=new G1();
        g2.setA(10);

        //自动拆箱
        System.out.println(g1.getA());
        System.out.println( g2.getA());
    }
}
