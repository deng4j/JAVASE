package dzh.com.GOF.Factory.AbstractFactory;

public interface CarFactory {
    Engine createEngine();
    Seat createSeat();
    Tyre creattyre();
}

class LuxuryCarFactory implements CarFactory{

    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat createSeat() {
        return new LuxurySseat();
    }

    @Override
    public Tyre creattyre() {
        return new Luxurytyre();
    }
}

class LowerCarFactory implements CarFactory{

    @Override
    public Engine createEngine() {
        return new LowerEngine();
    }

    @Override
    public Seat createSeat() {
        return new LowerSeat();
    }

    @Override
    public Tyre creattyre() {
        return new LowerTyre();
    }
}
