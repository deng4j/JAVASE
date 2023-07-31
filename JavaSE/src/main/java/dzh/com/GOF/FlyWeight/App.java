package dzh.com.GOF.FlyWeight;

/**
 * 享元模式应用场景：
 * 线程池，数据库连接池，String类设计。
 * 优点：1.极大减少内存中对象的数量。
 * 2.相同或相似对象内存中只存在一份，极大的节约资源，提高系统性能。
 * 3.外部状态相对独立，不影响内部状态。
 *
 * 缺点：
 * 1.模式较复杂，是程序逻辑复杂化。
 * 2.为了节省内存，共享了内部状态，分离出外部状态，而读取外部状态，
 * 使运行时间变长。
 */
public class App {
    public static void main(String[] args) {
        ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("黑色");
        ChessFlyWeight chess2 = ChessFlyWeightFactory.getChess("黑色");

        System.out.println(chess1==chess2);

        chess1.display(new Coordinate(10,50));
        chess2.display(new Coordinate(20,80));

    }
}
