package dzh.com.DesignPattern.DesignPattern.Builder.builder2;

/**
 * 天使角色建造器：具体建造者
 */
public class AngelBuilder extends ActorBuilder{

    @Override
    public void buildType() {
        this.actor.setType("天使");
    }

    @Override
    public void buildSex() {
        this.actor.setSex("女");
    }

    @Override
    public void buildFace() {
        this.actor.setFace("鹅蛋脸");
    }

    @Override
    public void buildCostume() {
        this.actor.setCostume("中世纪装甲");
    }

    @Override
    public void buildHairstyle() {
        this.actor.setHairstyle("黄色长发");
    }
}
