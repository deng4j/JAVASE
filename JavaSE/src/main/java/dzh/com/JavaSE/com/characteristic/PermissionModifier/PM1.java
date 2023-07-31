package dzh.com.JavaSE.com.characteristic.PermissionModifier;

public class PM1 {

    /**
     * default (即默认，什么也不写）: 在同一包内可见，不使用任何修饰符。使用对象：类、接口、变量、方法。
     */
    void show1() {
        System.out.println("default");
    }

    /**
     * private : 在同一类内可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
     */
    private void show2() {
        System.out.println("private");
    }

    /**
     * public : 对所有类可见。使用对象：类、接口、变量、方法
     */
    public void show3() {
        System.out.println("public");
    }

    /**
     * protected : 对同一包内的类和所有子类可见。使用对象：变量、方法。 注意：不能修饰类（外部类）。
     */
    protected void show4() {
        System.out.println("protected");
    }
}
