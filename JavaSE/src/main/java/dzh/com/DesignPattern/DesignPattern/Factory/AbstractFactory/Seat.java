package dzh.com.DesignPattern.DesignPattern.Factory.AbstractFactory;

public interface Seat {
    void massage();
}

class LuxurySseat implements Seat{

    @Override
    public void massage() {
        System.out.println("高端座自动按摩");
    }
}

class LowerSeat implements Seat{

    @Override
    public void massage() {
        System.out.println("低端座椅简洁");
    }
}
