package dzh.com.JavaSE.com.characteristic.block;

public class part {
    /**
     * 限定变量生命周期
     */
    int b;
    {
        b=100;
    }

    public int getB() {
        return b;
    }

    public static void main(String[] args) {
        part p=new part();
        System.out.println(p.getB());
    }
}
