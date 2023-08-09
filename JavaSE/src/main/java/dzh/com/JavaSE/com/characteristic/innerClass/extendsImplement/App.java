package dzh.com.JavaSE.com.characteristic.innerClass.extendsImplement;

public class App {
    public static void main(String[] args) {
        Outer3 outer3 = new Outer3();
        Outer3.Inner3 inner = outer3.getInner();
        inner.show();
    }
}
