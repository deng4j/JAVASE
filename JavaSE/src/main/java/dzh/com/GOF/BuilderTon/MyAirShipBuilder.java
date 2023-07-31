package dzh.com.GOF.BuilderTon;

/**
 * builderString,PreparedStatement,DomBuilder,SAXBuilder就是使用建造者模式
 * 使用构建者模式创建飞船
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
