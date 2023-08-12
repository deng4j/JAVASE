package dzh.com.DesignPattern.DesignPattern.structuralPatterns.proxy.dynamicProxy.cglibproxy;

import net.sf.cglib.core.DebuggingClassWriter;

/**
 * 目的：都是生成一个新的类，去实现增强代码逻辑的功能
 *
 * CGLib 可以代理任意一个普通的类，没有任何要求。
 * <p>
 * CGLIB 原理：动态生成一个要代理类的子类，子类重写要代理的类的所有不是final的方法。在子类中采用方法拦截的技术拦截所有父类方法的调用，顺势织入横切逻辑。它比使用java反射的JDK动态代理要快。
 * <p>
 * CGLIB 底层：使用字节码处理框架ASM，来转换字节码并生成新的类。不鼓励直接使用ASM，因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉。
 * <p>
 * CGLIB缺点：对于final方法，无法进行代理。
 */
public class CglibApp {
    public static void main(String[] args) {

        try {
            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/deng4j/Downloads/packages/cglib_proxy_classes");

            Customer obj = (Customer) new CglibMeipo().getInstance(Customer.class);
            obj.findLove();
            System.out.println(obj.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
