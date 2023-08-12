package dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.AirShipBuilder;

import dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.AirShipBuilder.domain.AirShip;

public class TestApp {
    public static void main(String[] args) {
        MyAirShiDirector myAirShiDirector = new MyAirShiDirector(new MyAirShipBuilder());
        AirShip airShip = myAirShiDirector.createAirShip();
        airShip.launch();
    }
}
