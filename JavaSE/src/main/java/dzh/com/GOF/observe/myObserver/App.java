package dzh.com.GOF.observe.myObserver;

/**
 * 观察者模式:广播
 */
public class App {
    public static void main(String[] args) {
        //创建目标对象
        ConcreteSubject subject=new ConcreteSubject();
        //创建三个观察者对象
        ObserverA obs1=new ObserverA();
        ObserverA obs2=new ObserverA();
        ObserverA obs3=new ObserverA();

        //将这三个观察者添加到subject对象的观察者队伍中
        subject.registerObserver(obs1);
        subject.registerObserver(obs2);
        subject.registerObserver(obs3);

        //改变subject的状态
        subject.setState(3000);

        //查看观察者状态是不是也改变了
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());

    }
}