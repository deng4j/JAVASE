package dzh.com.DesignPattern.DesignPattern.Builder.builder3;

public class Client {
    public static void main(String[] args) {
        ActorBuilder angelBuilder =new AngelBuilder();
        ActorBuilder heroBuilder =new HeroBuilder();
        DevilBuilder devilBuilder = new DevilBuilder();

        System.out.println(ActorBuilder.construct(angelBuilder));
        System.out.println(ActorBuilder.construct(heroBuilder));
        System.out.println(ActorBuilder.construct(devilBuilder));
    }
}
