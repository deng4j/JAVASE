package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.memento;

/**
 * Caretaker（负责人）：负责人又称为管理者，它负责保存备忘录，但是不能对备忘录的内容 进行操作或检查。
 * 在负责人类中可以存储一个或多个备忘录对象，它只负责存储对象，而不能修改对象，也无须知道对象的实现细节。
 */
public class CareTaker {
    private Memento empMemento;

    /**
     * 通过容器备忘多次
     */
    //private List<EmpMemento> list=new ArrayList<>();

    public Memento getEmpMemento() {
        return empMemento;
    }

    public void setEmpMemento(Memento empMemento) {
        this.empMemento = empMemento;
    }
}
