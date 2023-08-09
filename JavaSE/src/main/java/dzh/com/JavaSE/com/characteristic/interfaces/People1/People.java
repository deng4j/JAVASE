package dzh.com.JavaSE.com.characteristic.interfaces.People1;

/**
 * 测试抽象类实现接口
 * 抽象类也可以实现接口方法，但是必须有方法体
 */
public abstract class People implements Hand{

    public People() {
        System.out.println("---人体初始化中---");
        this.hand();
    }
}
