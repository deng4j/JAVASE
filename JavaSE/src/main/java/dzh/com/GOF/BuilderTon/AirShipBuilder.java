package dzh.com.GOF.BuilderTon;

public interface AirShipBuilder {
    OrbitalModule builderOrbitalModule();
    Engine builderEngine();
    EscapeTower builderEscapeTower();
}
