package dzh.com.DesignPattern.DesignPattern.Builder.builder3;

/**
 * 英雄角色建造器：具体建造者
 */
public class HeroBuilder extends ActorBuilder {
    @Override
    public void buildType() {
        actor.setType("英雄");
    }

    @Override
    public void buildSex() {
        actor.setSex("男");
    }

    @Override
    public void buildFace() {
        actor.setFace("方正");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("中世纪装甲");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("短寸");
    }
}
