package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.observer.myObserver.observer;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.observer.myObserver.subject.ConcreteSubject;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.observer.myObserver.subject.Subject;

public class ObserverA implements Observer {
    /**
     * myState需要跟目标对象的state值保持一致
     */
    private int myState;

    @Override
    public void update(Subject subject) {
        myState=((ConcreteSubject)subject).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
