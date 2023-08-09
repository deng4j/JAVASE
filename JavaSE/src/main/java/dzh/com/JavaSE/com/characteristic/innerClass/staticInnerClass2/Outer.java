package dzh.com.JavaSE.com.characteristic.innerClass.staticInnerClass2;

public class Outer {

    private static class Inner implements PartA{
        @Override
        public void show(){
            System.out.println("inner");
        }
    }

    public static Inner newInstance() {
        return new Inner();
    }
}
