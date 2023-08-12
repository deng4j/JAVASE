package dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.AirShipBuilder;

import dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.AirShipBuilder.domain.Engine;
import dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.AirShipBuilder.domain.EscapeTower;
import dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.AirShipBuilder.domain.OrbitalModule;

/**
 * 抽象建造者
 */
public interface AirShipBuilder {
    OrbitalModule builderOrbitalModule();
    Engine builderEngine();
    EscapeTower builderEscapeTower();
}
