package dzh.com.JavaSE.com.characteristic.innerClass.extendsImplement;


interface Interface{
    void show();
}

abstract class Farther{
    abstract void show();
}

public class Outer3 {

    // 继承实现
    class Inner3 extends Farther implements Interface{

        @Override
        public void show() {
            System.out.println("Inner3 show");
        }
    }

    public Inner3 getInner(){
        return new Inner3();
    }
}
