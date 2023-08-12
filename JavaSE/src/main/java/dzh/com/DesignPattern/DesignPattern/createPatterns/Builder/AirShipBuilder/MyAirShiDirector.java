package dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.AirShipBuilder;

import dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.AirShipBuilder.domain.AirShip;
import dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.AirShipBuilder.domain.Engine;
import dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.AirShipBuilder.domain.EscapeTower;
import dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.AirShipBuilder.domain.OrbitalModule;

/**
 * 具体指挥者
 */
public class MyAirShiDirector implements AirShipDirector {
   /**
    *  用于存储对象的引用,MyAirShipBuilder向上转型（多态）
    */
    private AirShipBuilder builder;

    public MyAirShiDirector(AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip createAirShip() {
        OrbitalModule orbitalModule = builder.builderOrbitalModule();
        Engine engine = builder.builderEngine();
        EscapeTower escapeTower = builder.builderEscapeTower();
        //装配
        AirShip airShip=new AirShip();
        airShip.setOrbitalModule(orbitalModule);
        airShip.setEngine(engine);
        airShip.setEscapeTower(escapeTower);
        return airShip;
    }
}
