package dzh.com.JavaSE.com.characteristic.innerClass.inner1;


public class A {

    private int a;

    public void setA(int a) {
        this.a = a;
    }

    public class B{
        private void show(){
            // 拿到外部类的引用
            System.out.println(a);
        }
    }

    public B newB(){
        return new B();
    }

    public static void main(String[] args) {
        A aaa = new A();
        B b = aaa.newB();

        b.show();

        aaa.setA(10);

        b.show();
    }
}
