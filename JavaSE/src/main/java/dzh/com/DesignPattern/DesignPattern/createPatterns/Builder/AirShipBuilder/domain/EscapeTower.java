package dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.AirShipBuilder.domain;

/**
 * 逃逸仓类
 */
public class EscapeTower{
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