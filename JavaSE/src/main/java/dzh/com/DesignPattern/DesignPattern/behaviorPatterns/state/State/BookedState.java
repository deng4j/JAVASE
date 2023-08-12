package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.state.State;

/**
 *  ConcreteState（具体状态类）：它是抽象状态类的子类，每一个子类实现一个与环境类的一个状态相关的行为，每一个具体状态类对应环境的一个具体状态，不同的具体状态类其行为有所不同。
 */
public class BookedState implements State{
    @Override
    public void handle() {
        System.out.println("房间已预订");
    }
}