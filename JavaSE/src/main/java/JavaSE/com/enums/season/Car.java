package JavaSE.com.enums.season;

public enum Car {
    AUDI(){
        @Override
        void run() {
            System.out.println("奥迪在跑");
        }
    };

    public Car getAudi() {
        return AUDI;
    }

    abstract void run();

    private String name="奥迪a6";

    public String getName() {
        return name;
    }
}
