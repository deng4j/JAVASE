package dzh.com.DesignPattern.DesignPattern.Builder.builder2;

/**
 * 英雄角色建造器：具体建造者
 */
public class HeroBuilder extends ActorBuilder{
    @Override
    public void buildType() {
        this.actor.setType("英雄");
    }

    @Override
    public void buildSex() {
        this.actor.setSex("男");
    }

    @Override
    public void buildFace() {
        this.actor.setFace("方正");
    }

    @Override
    public void buildCostume() {
        this.actor.setCostume("中世纪装甲");
    }

    @Override
    public void buildHairstyle() {
        this.actor.setHairstyle("短寸");
    }
}