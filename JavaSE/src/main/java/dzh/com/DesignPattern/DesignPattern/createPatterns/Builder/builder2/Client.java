package dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.builder2;

public class Client {
    public static void main(String[] args) {
        ActorBuilder angelBuilder =new AngelBuilder();
        ActorBuilder heroBuilder =new HeroBuilder();
        DevilBuilder devilBuilder = new DevilBuilder();

        ActorController actorController =new ActorController(angelBuilder);
        System.out.println(actorController.createActor());

        actorController.setActorBuilder(heroBuilder);
        System.out.println(actorController.createActor());

        actorController.setActorBuilder(devilBuilder);
        System.out.println(actorController.createActor());
    }
}
