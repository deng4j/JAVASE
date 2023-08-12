package dzh.com.DesignPattern.DesignPattern.structuralPatterns.FlyWeight.flyWeight1;

/**
 * 享元模式应用场景：
 * 线程池，数据库连接池，String类设计。
 *
 * 优点：
 * 1.极大减少内存中对象的数量。
 * 2.相同或相似对象内存中只存在一份，极大的节约资源，提高系统性能。
 * 3.外部状态相对独立，不影响内部状态。
 *
 * 缺点：
 * 1.模式较复杂，是程序逻辑复杂化。
 * 2.为了节省内存，共享了内部状态，分离出外部状态，而读取外部状态，使运行时间变长。
 *
 * 适用场景:
 * 1.一个系统有大量相同或者相似的对象，造成内存的大量耗费。
 * 2.对象的大部分状态都可以外部化，可以将这些外部状态传入对象中。
 * 3.在使用享元模式时需要维护一个存储享元对象的享元池，而这需要耗费一定的系统资源， 因此，应当在需要多次重复使用享元对象时才值得使用享元模式。
 *
 * 标准的享元模式:结构图中既包含可以共享的具体享元类，也包含不可以共享的非共享具体享 元类。但是在实际使用过程中，我们有时候会用到两种特殊的享元模式：单纯享元模式和复合享元模式。
 * 单纯享元模式:在单纯享元模式中，所有的具体享元类都是可以共享的，不存在非共享具体享元类。
 * 复合享元模式：将一些单纯享元对象使用组合模式加以组合，还可以形成复合享元对象，这样的复合享元对象本身不能共享，但是它们可以分解成单纯享元对象，而后者则可以共享。
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
