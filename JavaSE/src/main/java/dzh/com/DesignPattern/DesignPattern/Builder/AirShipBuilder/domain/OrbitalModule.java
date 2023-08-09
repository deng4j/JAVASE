package dzh.com.DesignPattern.DesignPattern.Builder.AirShipBuilder.domain;

/**
 * 轨道舱类
 */
public class OrbitalModule{
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