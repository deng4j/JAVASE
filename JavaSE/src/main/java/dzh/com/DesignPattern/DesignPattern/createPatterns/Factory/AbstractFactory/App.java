package dzh.com.DesignPattern.DesignPattern.createPatterns.Factory.AbstractFactory;

/**
 * 抽象工厂：
 *  不可以增加产品，否则需要为每个工厂增加产品创建方法；
 *  可以增加产品族，如一套顶级发动机、座椅、轮胎。只需要新增一个顶级汽车工厂。
 */
public class App {
    public static void main(String[] args) {
        LuxuryCarFactory luxuryCarFactory = new LuxuryCarFactory();

        Engine Luxryengine = luxuryCarFactory.createEngine();
        Luxryengine.run();
        Luxryengine.start();

        Seat luxurySeat = luxuryCarFactory.createSeat();
        luxurySeat.massage();

        Tyre luxurytyre = luxuryCarFactory.creattyre();
        luxurytyre.revolve();
    }
}
