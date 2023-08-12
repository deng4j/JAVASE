package dzh.com.JavaSE.com.characteristic.Abstract;

/**
 * 抽象类是用于描述对象的；
 * 抽象类除了不能实例化对象之外，类的其它功能依然存在，成员变量、成员方法和构造方法的访问方式和普通类一样。
 * 由于抽象类不能实例化对象，所以抽象类必须被继承，才能被使用。
 * <p>
 * JDK 1.8以前，抽象类的方法默认访问权限为protected
 * JDK 1.8时，抽象类的方法默认访问权限变为default
 */
public abstract class Farther {
    public String name;

    /**
     * 抽象方法只包含一个方法名，而没有方法体。
     * 子类必须重写父类的抽象方法，或者声明自身为抽象类。
     */
    public abstract void work();

    public void show() {
        System.out.println("我是Farther");
    }
}

class Children extends Farther {

    /**
     * 重写后的方法访问权限必须大于等于父类中的方法权限
     */
    @Override
    public void work() {
        System.out.println("我是Children");
    }

    public static void main(String[] args) {
        Children children = new Children();
        children.name = "kk";
        children.work();
        System.out.println(children.name);
    }
}
