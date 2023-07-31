package dzh.com.GOF.Factory.AbstractFactory;

public interface Engine {
    void run();
    void start();
}

class LuxuryEngine implements Engine{

    @Override
    public void run() {
        System.out.println("高端发动机转速快");
    }

    @Override
    public void start() {
        System.out.println("高端发动机自动启停");
    }
}

class LowerEngine implements Engine{

    @Override
    public void run() {
        System.out.println("低端发动机转速慢");
    }

    @Override
    public void start() {
        System.out.println("低端发动机没有自动启停");
    }
}
