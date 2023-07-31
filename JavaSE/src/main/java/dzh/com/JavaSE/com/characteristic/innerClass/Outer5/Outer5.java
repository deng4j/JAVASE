package dzh.com.JavaSE.com.characteristic.innerClass.Outer5;

public class Outer5 {
    //静态内部类
    static class StaticInner{
        private static String name;

        public void show(){
            System.out.println("静态内部类");
        }
    }

    public void show(){
        new Outer5.StaticInner().show();
    }
}
