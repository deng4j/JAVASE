package dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.builder2;

import dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.builder2.ConcreteBuilder.AngelBuilder;
import dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.builder2.ConcreteBuilder.DevilBuilder;
import dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.builder2.ConcreteBuilder.HeroBuilder;

public class Client {
    public static void main(String[] args) {
        ActorBuilder angelBuilder =new AngelBuilder();
        ActorBuilder heroBuilder =new HeroBuilder();
        ActorBuilder devilBuilder = new DevilBuilder();

        ActorController actorController =new ActorController(angelBuilder);
        System.out.println(actorController.createActor());

        actorController.setActorBuilder(heroBuilder);
        System.out.println(actorController.createActor());

        actorController.setActorBuilder(devilBuilder);
        System.out.println(actorController.createActor());
    }
}
