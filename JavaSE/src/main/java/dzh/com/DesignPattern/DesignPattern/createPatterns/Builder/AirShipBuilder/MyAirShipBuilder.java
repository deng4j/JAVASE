package dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.AirShipBuilder;

import dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.AirShipBuilder.domain.Engine;
import dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.AirShipBuilder.domain.EscapeTower;
import dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.AirShipBuilder.domain.OrbitalModule;

/**
 * builderString,PreparedStatement,DomBuilder,SAXBuilder就是使用建造者模式
 * 具体建造者
 */
public class MyAirShipBuilder implements AirShipBuilder{
    @Override
    public OrbitalModule builderOrbitalModule() {
        return new OrbitalModule("轨道舱");
    }

    @Override
    public Engine builderEngine() {
        return new Engine("发动机");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        return new EscapeTower("逃逸塔");
    }
}
