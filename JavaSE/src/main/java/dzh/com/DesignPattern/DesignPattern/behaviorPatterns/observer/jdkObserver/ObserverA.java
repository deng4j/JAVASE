package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.observer.jdkObserver;

import java.util.Observable;
import java.util.Observer;

public class ObserverA  implements Observer {
    private int myState;
    @Override
    public void update(Observable o, Object arg) {
        myState=((ConcreteSubject)o).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
