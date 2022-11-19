package JavaSE.com.genericity;

public class OverClass<T> {
    private  T a;

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        //自动装箱
        OverClass<Boolean> o=new OverClass();
        o.setA(true);

        OverClass<Integer> o2=new OverClass();
        o2.setA(10);

        //自动拆箱
        System.out.println(o.getA());
        System.out.println( o2.getA());

    }
}
