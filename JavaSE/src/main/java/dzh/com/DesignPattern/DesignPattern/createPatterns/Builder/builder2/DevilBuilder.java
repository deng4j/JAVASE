package dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.builder2;

/**
 * 恶魔角色建造器：具体建造者
 */
public class DevilBuilder extends ActorBuilder{
    @Override
    public void buildType() {
        this.actor.setType("恶魔");
    }

    @Override
    public void buildSex() {
        this.actor.setSex("男");
    }

    @Override
    public void buildFace() {
        this.actor.setFace("杏仁形脸");
    }

    @Override
    public void buildCostume() {
        this.actor.setCostume("皮甲");
    }

    @Override
    public void buildHairstyle() {
        this.actor.setHairstyle("紫黑色长发");
    }
}
