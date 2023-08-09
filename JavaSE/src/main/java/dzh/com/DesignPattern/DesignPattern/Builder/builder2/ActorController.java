package dzh.com.DesignPattern.DesignPattern.Builder.builder2;

/**
 * 游戏角色创建控制器：指挥者
 */
public class ActorController {
    private ActorBuilder actorBuilder;

    public ActorController(ActorBuilder actorBuilder) {
        this.actorBuilder = actorBuilder;
    }


    public void setActorBuilder(ActorBuilder actorBuilder) {
        this.actorBuilder = actorBuilder;
    }

    public Actor createActor() {
        this.actorBuilder.buildType();
        this.actorBuilder.buildSex();
        this.actorBuilder.buildFace();
        this.actorBuilder.buildCostume();
        this.actorBuilder.buildHairstyle();
        this.actorBuilder.buildType();
        return this.actorBuilder.createActor();
    }
}
