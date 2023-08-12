package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.state;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.state.State.State;

/**
 *  Context（环境类）：环境类又称为上下文类，它是拥有多种状态的对象。由于环境类的状态存在多样性且在不同状态下对象的行为有所不同，因此将状态独立出去形成单独的状态类。
 *  在环境类中维护一个抽象状态类State的实例，这个实例定义当前状态，在具体实现时，它是一个State子类的对象。
 */
public class Context {
    private State state;

    public void setState(State state) {
        System.out.println("----修改状态----");
        this.state = state;
        this.state.handle();

    }
}
