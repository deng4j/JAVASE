package dzh.com.JavaSE.com.base;

public class EqualSign {

    /**
     * "=="比较基本数据类型时比较的是表面值内容，而比较两个对象时比较的是两个对象的内存地址值
     * 如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；
     */
    private static void m1() {
        String s1 = String.valueOf(12);
        String s2 = String.valueOf(12);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
