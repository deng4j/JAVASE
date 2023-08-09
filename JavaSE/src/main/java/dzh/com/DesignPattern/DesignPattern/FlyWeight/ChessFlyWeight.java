package dzh.com.DesignPattern.DesignPattern.FlyWeight;

/**
 * 享元类：
 * 棋子的颜色是共享的
 */
public interface ChessFlyWeight {
    void setColor(String c);
    String getColor();
    void display(Coordinate c);
}

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
