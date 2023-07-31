package dzh.com.JavaSE.com.base;

/**
 * 隐含类型转换：
 *  - 整数的默认类型是 int。
 *  - 小数默认是 double 类型浮点型，在定义 float 类型时必须在数字后面跟上 F 或者 f。
 *
 * 自动类型转换：
 *  - 算数运算中，不同类型的数据先转化为同一类型，然后进行运算。转换从低级到高级（算数运算）：
 *      byte -> short ↘
 *                     int —> long—> float —> double
 *               char ↗
 *  - 赋值运算，满足自动类型转换：
 *    1.两种类型要兼容，数值类型（整数和浮点数）相互兼容
 *    2.目标类型大于源类型，如double大于int
 *
 * 类型转换必须满足如下规则：
 * 1.不能对boolean类型进行类型转换。
 * 2.不能把对象类型转换成不相关类的对象。
 * 3.在把容量大的类型转换为容量小的类型时必须使用强制类型转换。
 * 4.转换过程中可能导致溢出或损失精度，
 *
 */
public class Cast {
    public static void main(String[] args) {
        m2();
    }

    private static void m2() {
        // 强转丢失精度
        System.out.println((int)1.1111);
        System.out.println((float) 1);

        // 强转丢失精度
        System.out.println((int)1.1111D);
        System.out.println((float) 1.11110000222223333D);
    }

    private static void m1() {
        int a = 1234567890;
        // a的值已经远超byte类型的范围
        byte b = (byte)a;
        System.out.println("int强制类型转换为byte后的值等于"+b);
    }
}
