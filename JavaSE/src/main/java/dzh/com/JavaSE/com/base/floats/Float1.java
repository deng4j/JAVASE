package dzh.com.JavaSE.com.base.floats;

/**
 * float 数据类型是单精度、32位、符合IEEE 754标准的浮点数；
 * float 在储存大型浮点数组的时候可节省内存空间；
 * 默认值是 0.0f；
 * 浮点数不能用来表示精确的值，如货币；
 */
public class Float1 {
    public static void main(String[] args) {
        float f1 = 1.1f;
        float f2 = 1.1F;
        System.out.println(f1==f2);

        Float f3 = 1.1f; // 自动装箱
        float f4 = Float.valueOf(1.1f); // 自动拆箱
        System.out.println(f3==f4);
    }
}
