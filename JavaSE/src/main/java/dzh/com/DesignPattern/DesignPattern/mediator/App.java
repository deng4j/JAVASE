package dzh.com.DesignPattern.DesignPattern.mediator;

/**
 * 中介模式：
 * 解耦多个同事对象之间的交互关系。每个对象都持有中介者对象的引用，
 * 只跟中介者对象打交道。通过中介者对象统一管理这些交互关系。
 */
public class App {
    public static void main(String[] args) {
        Mediator president=new President();

        Market market=new Market(president);
        Development development=new Development(president);
        Finacial finacial=new Finacial(president);

        market.selfAction();
        market.outAction();

    }
}
