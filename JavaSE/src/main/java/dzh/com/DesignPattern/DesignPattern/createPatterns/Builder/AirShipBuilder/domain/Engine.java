package dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.AirShipBuilder.domain;

/**
 * 发动机类
 */
public class Engine{
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