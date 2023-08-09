package dzh.com.DesignPattern.DesignPattern.Builder.builder3;

/**
 * 恶魔角色建造器：具体建造者
 */
public class DevilBuilder extends ActorBuilder {
    @Override
    public void buildType() {
        actor.setType("恶魔");
    }

    @Override
    public void buildSex() {
        actor.setSex("男");
    }

    @Override
    public void buildFace() {
        actor.setFace("杏仁形脸");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("皮甲");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("紫黑色长发");
    }
}
