package dzh.com.DesignPattern.DesignPattern.createPatterns.ProtoType.PrototypeManager;

/**
 * 抽象公文接口
 */
interface OfficialDocument extends Cloneable {
    public OfficialDocument clone();

    public void display();
}