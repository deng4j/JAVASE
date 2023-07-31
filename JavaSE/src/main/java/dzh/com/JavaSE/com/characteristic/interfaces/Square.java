package dzh.com.JavaSE.com.characteristic.interfaces;

interface Quadrate {
    void sides();
}

interface Parallelogram extends Quadrate{
    void parallel();
}

public class Square implements Parallelogram{
    @Override
    public void sides() {
        System.out.println("四条边");
    }

    @Override
    public void parallel() {
        System.out.println("对边平行");
    }

    public void eqSides() {
        System.out.println("四条边相等");
    }

    public void get() {
        sides();
        parallel();
        eqSides();
    }

    public static void main(String[] args) {
        Square square = new Square();
        square.get();
    }
}

