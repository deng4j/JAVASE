package JavaSE.com.GOF.BuilderTon;

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

/**
 * 轨道舱类
 */
class OrbitalModule{
    private String name;

    public OrbitalModule() {
    }

    public OrbitalModule(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 发动机类
 */
class Engine{
    private String naem;

    public Engine() {
    }

    public Engine(String naem) {
        this.naem = naem;
    }

    public String getNaem() {
        return naem;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }
}

/**
 * 逃逸仓类
 */
class EscapeTower{
    private String name;

    public EscapeTower(String name) {
        this.name = name;
    }

    public EscapeTower() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
