package dzh.com.JavaSE.com.characteristic.StaticFinal;

/**
 * 不能再方法中定义静态变量
 * 静态方法不能有this
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
