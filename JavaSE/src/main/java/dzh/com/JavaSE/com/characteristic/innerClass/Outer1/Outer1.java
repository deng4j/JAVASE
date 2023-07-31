package dzh.com.JavaSE.com.characteristic.innerClass.Outer1;

public class Outer1 {
    private Integer nnn = 10;

    // 私有内部类
    private class Inner1{
        // 访问到外部类的成员属性
        private Integer aaa = nnn;
    }

    public int show(){
        Inner1 inner1 = new Inner1();
        return inner1.aaa;
    }
}
