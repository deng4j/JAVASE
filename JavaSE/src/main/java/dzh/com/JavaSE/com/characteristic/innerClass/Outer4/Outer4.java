package dzh.com.JavaSE.com.characteristic.innerClass.Outer4;

public class Outer4 {

    private int f = 1;

    public void show(){
        // 局部内部类
        class Inner4{
            public void show(){
                System.out.println(f);
            }
        }

        new Inner4().show();
    }
}
