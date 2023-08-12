package dzh.com.DesignPattern.DesignPattern.structuralPatterns.FlyWeight.flyWeight1;

/**
 * 棋子的坐标是外部类：不共享的
 *
 *  UnsharedConcreteFlyweight（非共享具体享元类）：并不是所有的抽象享元类的子类都需要 被共享，不能被共享的子类可设计为非共享具体享元类；
 *  当需要一个非共享具体享元类的对 象时可以直接通过实例化创建。
 */
public class Coordinate {
    private int x,y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
