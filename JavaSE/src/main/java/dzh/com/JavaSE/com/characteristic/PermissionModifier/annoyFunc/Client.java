package dzh.com.JavaSE.com.characteristic.PermissionModifier.annoyFunc;

import dzh.com.JavaSE.com.characteristic.PermissionModifier.annoyFunc.p1.P;

/**
 * 受protected修饰的构造，外部想要调用，必须使用匿名类
 */
public class Client {
    public static void main(String[] args) {
        P p = new P(){};
    }
}
