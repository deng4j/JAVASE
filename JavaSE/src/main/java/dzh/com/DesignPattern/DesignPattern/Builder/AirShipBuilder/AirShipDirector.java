package dzh.com.DesignPattern.DesignPattern.Builder.AirShipBuilder;

import dzh.com.DesignPattern.DesignPattern.Builder.AirShipBuilder.domain.AirShip;

/**
 * 抽象指挥者
 */
public interface AirShipDirector {
    AirShip createAirShip();
}
