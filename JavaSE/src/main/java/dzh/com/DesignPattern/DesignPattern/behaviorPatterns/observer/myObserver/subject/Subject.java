package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.observer.myObserver.subject;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.observer.myObserver.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 *  Subject（目标）：目标又称为主题，它是指被观察的对象。在目标中定义了一个观察者集合，一个观察目标可以接受任意数量的观察者来观察，
 *  它提供一系列方法来增加和删除观察者对象，同时它定义了通知方法notify()。目标类可以是接口，也可以是抽象类或具体类。
 */
public abstract class Subject {
    protected List<Observer> list=new ArrayList<>();

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
