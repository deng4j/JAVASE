package dzh.com.JavaSE.com.characteristic.block;

public class Part {
    /**
     * 限定变量生命周期
     */
    static int b=10;
    {
        b=100;
    }

    public int getB() {
        return b;
    }

    public static void main(String[] args) {
        Part p=new Part();
        System.out.println(p.getB());

        System.out.println(Part.b);
    }
}
