package dzh.com.JavaSE.com.characteristic.extend.extend2;

/**
 * 测试构造方法执行顺序
 */
public class Child extends Farther{
    public Child() {
        System.out.println("Child");
    }

    public static void main(String[] args) {
        new Child();
    }
}
