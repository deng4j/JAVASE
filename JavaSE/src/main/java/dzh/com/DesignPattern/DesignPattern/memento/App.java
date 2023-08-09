package dzh.com.DesignPattern.DesignPattern.memento;

/**
 * 备忘录模式
 */
public class App {
    public static void main(String[] args) {
        CareTaker taker=new CareTaker();

        Emp emp=new Emp("杨过",38,40000);
        System.out.println("开始："+emp);

        //备忘一次
        taker.setEmpMemento(emp.memento());

        emp.setAge(40);
        System.out.println("改变："+emp);

        //恢复
        emp.recovery(taker.getEmpMemento());

        System.out.println("恢复："+emp);
    }
}
