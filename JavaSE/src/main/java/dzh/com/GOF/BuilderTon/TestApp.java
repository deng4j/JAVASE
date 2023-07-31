package dzh.com.GOF.BuilderTon;

public class TestApp {
    public static void main(String[] args) {
        MyAirShiDirector myAirShiDirector = new MyAirShiDirector(new MyAirShipBuilder());
        AirShip airShip = myAirShiDirector.createAirShip();
        airShip.launch();
    }
}
