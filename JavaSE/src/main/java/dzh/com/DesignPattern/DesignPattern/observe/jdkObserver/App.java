package dzh.com.DesignPattern.DesignPattern.observe.jdkObserver;

public class App {
    public static void main(String[] args) {
        ConcreteSubject subject=new ConcreteSubject();

        ObserverA ob1=new ObserverA();
        ObserverA ob2=new ObserverA();
        ObserverA ob3=new ObserverA();

        subject.addObserver(ob1);
        subject.addObserver(ob2);
        subject.addObserver(ob3);

        subject.set(3004);

        System.out.println(ob1.getMyState());
        System.out.println(ob2.getMyState());
        System.out.println(ob3.getMyState());

    }
}
