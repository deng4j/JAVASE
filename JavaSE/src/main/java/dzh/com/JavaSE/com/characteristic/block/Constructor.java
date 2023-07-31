package dzh.com.JavaSE.com.characteristic.block;

public class Constructor {

    /**
     * 优先于构造方法,并且每次调用构造方法前都会执行一次
     */
    {
        System.out.println("我是构造代码块");
    }

    public Constructor() {
        System.out.println("Constructor");
    }

    public Constructor( int a) {
        System.out.println("Constructor(int a)");
    }

    public static void main(String[] args) {
        Constructor c1=new Constructor();
        Constructor c2=new Constructor(10);
    }
}

