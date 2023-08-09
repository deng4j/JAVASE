package dzh.com.DesignPattern.DesignPattern.Builder.builder3;

/**
 * 角色建造器：抽象建造者
 * 
 * 在有些情况下，为了简化系统结构，可以将Director和抽象建造者Builder进行合并
 */
public abstract class ActorBuilder {
    protected static Actor actor = new Actor();

    public abstract void buildType();

    public abstract void buildSex();

    public abstract void buildFace();

    public abstract void buildCostume();

    public abstract void buildHairstyle();

    public static Actor construct(ActorBuilder actorBuilder) {
        actorBuilder.buildType();
        actorBuilder.buildSex();
        actorBuilder.buildFace();
        actorBuilder.buildCostume();
        actorBuilder.buildHairstyle();
        actorBuilder.buildType();
        return actor;
    }
}
