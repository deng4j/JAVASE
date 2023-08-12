package dzh.com.DesignPattern.DesignPattern.structuralPatterns.FlyWeight.flyWeight1;

/**
 * 棋子的颜色是共享的
 *
 * Flyweight（抽象享元类）：通常是一个接口或抽象类，在抽象享元类中声明了具体享元类公共的方法，这些方法可以向外界提供享元对象的内部数据（内部状态），
 * 同时也可以通过这 些方法来设置外部数据（外部状态）。
 */
public interface ChessFlyWeight {
    void setColor(String c);
    String getColor();
    void display(Coordinate c);
}

/**
 * ConcreteFlyweight（具体享元类）：它实现了抽象享元类，其实例称为享元对象；在具体享 元类中为内部状态提供了存储空间。通常我们可以结合单例模式来设计具体享元类，
 * 为每一个具体享元类提供唯一的享元对象。
 */
class ConcreteChess implements ChessFlyWeight{
    private String color;

    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public void setColor(String c) {
        this.color=c;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void display(Coordinate c) {
        System.out.println("棋子："+color+" 位置："+c.getX()+","+c.getY());
    }
}
