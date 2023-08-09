package dzh.com.JavaSE.com.characteristic.Static_;

/**
 * 静态成员不依赖于类的特定实例，被类的所有实例共享，就是说 static 修饰的方法或者变量不需要依赖于对象来进行访问，只要这个类被加载，Java 虚拟机就可以根据类名找到它们。
 *
 * 不能再方法中定义静态变量
 * 静态方法不能有this、super关键字
 * 静态方法不能直接调用非静态方法
 */
public class Static1 {
    static  int a=47;

    public static void show(){
          new Static1().set();
    }

    public void  set(){
        a=57;
        System.out.println(a);
    }

    public static void main(String[] args) {
        Static1 s=new Static1();
        s.set();

        Static1.show();
    }

}
