package JavaSE.com.GOF.Factory.AbstractFactory;

/**
 * 抽象工厂：不可以增加产品，可以增加产品族
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
