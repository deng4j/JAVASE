package dzh.com.JavaSE.com.characteristic.enums.season;

/**
 * 所有枚举类都是Enum的子类
 * <p>
 * 我们可以通过"枚举类名.枚举项名称"去访问指定的枚举项
 * <p>
 * 每一个枚举项其实就是该枚举的一个对象
 * <p>
 * 枚举也是一个类，也可以去定义成员变量
 * <p>
 * 枚举类的第一行上必须是枚举项，最后一个枚举项后的分号是可以省略的，但是如果枚举类有其他的东西，这个分号就不能省略。建议不要省略
 * <p>
 * 枚举类可以有构造器，但必须是private的，它默认的也是private的。
 * <p>
 * 枚举项的用法比较特殊：枚举("");
 * <p>
 * 枚举类也可以有抽象方法，但是枚举项必须重写该方法
 */
public enum Season {
    //通过有参构造创建枚举对象
    SPRING("春") {
        @Override
        void show() {

        }
    }, SUMMER("夏") {
        @Override
        void show() {

        }
    }, AUTUMN("秋") {
        @Override
        void show() {

        }
    },
    WINTER("冬") {
        @Override
        void show() {

        }
    };
    private String name;

    //空参
    private Season() {
    }

    //有参构造
    private Season(String name) {
    }

    abstract void show();
}
