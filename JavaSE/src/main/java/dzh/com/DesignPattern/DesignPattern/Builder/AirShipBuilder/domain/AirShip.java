package dzh.com.DesignPattern.DesignPattern.Builder.AirShipBuilder.domain;

public class AirShip {
    private OrbitalModule orbitalModule;
    private Engine engine;
    private EscapeTower escapeTower;

    public void launch(){
        System.out.println(orbitalModule.getName()+"+"+
        engine.getNaem()+"+"+escapeTower.getName()+"的火箭，发射");
    }

    public OrbitalModule getOrbitalModule() {
        return orbitalModule;
    }

    public void setOrbitalModule(OrbitalModule orbitalModule) {
        this.orbitalModule = orbitalModule;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public EscapeTower getEscapeTower() {
        return escapeTower;
    }

    public void setEscapeTower(EscapeTower escapeTower) {
        this.escapeTower = escapeTower;
    }
}

