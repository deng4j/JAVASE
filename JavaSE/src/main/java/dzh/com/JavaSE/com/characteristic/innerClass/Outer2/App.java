package dzh.com.JavaSE.com.characteristic.innerClass.Outer2;

public class App {
    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        Outer2.Inner2 inner2 = outer2.getInner2();
        inner2.show();
    }
}
