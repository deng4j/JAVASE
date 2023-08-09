package dzh.com.JavaSE.com.base.baseType.doubles;

/**
 * double 数据类型是双精度、64 位、符合 IEEE 754 标准的浮点数；
 * 浮点数的默认类型为 double 类型；
 * double类型同样不能表示精确的值，如货币；
 * 默认值是 0.0d；
 * 小数默认是 double 类型浮点型
 */
public class Double1 {
    public static void main(String[] args) {
        double d1 = 1.0d;
        double d2 = 1.;
        double d3 = 1.1111111111111111;
        double d4 = 1.D;
        System.out.println(d1==d2);
        System.out.println(d3);

        Double d5 = 1.1d; // 自动装箱
        double d6 = Double.valueOf(1.1); // 自动拆箱
        System.out.println(d5==d6);
    }
}
