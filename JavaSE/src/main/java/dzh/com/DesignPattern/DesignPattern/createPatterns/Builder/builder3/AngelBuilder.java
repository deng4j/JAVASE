package dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.builder3;

/**
 * 天使角色建造器：具体建造者
 */
public class AngelBuilder extends ActorBuilder {

    @Override
    public void buildType() {
        actor.setType("天使");
    }

    @Override
    public void buildSex() {
        actor.setSex("女");
    }

    @Override
    public void buildFace() {
        actor.setFace("鹅蛋脸");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("中世纪装甲");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("黄色长发");
    }
}
