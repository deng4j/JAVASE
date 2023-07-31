package dzh.com.GOF.observe.myObserver;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    protected List<Observer > list=new ArrayList<>();

    public void  registerObserver(Observer observer){
        list.add(observer);
    }

    public void removeObserver (Observer obs){
        list.remove(obs);
    }

    /**
     * 通知所有观察者更新状态
     */
    public void notifyAllObserver(){
        for (int i = 0; i < list.size(); i++) {
            list.get(i).update(this);
        }
    }

}
