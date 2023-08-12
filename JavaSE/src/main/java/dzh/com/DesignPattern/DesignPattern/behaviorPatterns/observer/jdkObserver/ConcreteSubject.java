package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.observer.jdkObserver;

import java.util.Observable;

public class ConcreteSubject extends Observable {
    private int state;

    public void  set(int s){
        //目标对象状态已经发生改变
        state=s;
        //表示目标对象已经做了更改
        setChanged();
        //通知所有观察者
        this.notifyObservers(state);
    }

    public int getState() {
        return state;
    }
}
