package dzh.com.DesignPattern.DesignPattern.createPatterns.Factory.AbstractFactory;

public interface Tyre {
    void revolve();
}

class Luxurytyre implements Tyre{

    @Override
    public void revolve() {
        System.out.println("高端轮胎抓力好磨损满");
    }
}
class LowerTyre implements Tyre{

    @Override
    public void revolve() {
        System.out.println("低端轮胎磨损快");
    }
}
