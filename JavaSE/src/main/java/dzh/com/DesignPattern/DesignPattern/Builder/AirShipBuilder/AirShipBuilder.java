package dzh.com.DesignPattern.DesignPattern.Builder.AirShipBuilder;

import dzh.com.DesignPattern.DesignPattern.Builder.AirShipBuilder.domain.Engine;
import dzh.com.DesignPattern.DesignPattern.Builder.AirShipBuilder.domain.EscapeTower;
import dzh.com.DesignPattern.DesignPattern.Builder.AirShipBuilder.domain.OrbitalModule;

/**
 * 抽象建造者
 */
public interface AirShipBuilder {
    OrbitalModule builderOrbitalModule();
    Engine builderEngine();
    EscapeTower builderEscapeTower();
}
