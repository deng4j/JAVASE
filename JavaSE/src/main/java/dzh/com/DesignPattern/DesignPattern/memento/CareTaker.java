package dzh.com.DesignPattern.DesignPattern.memento;

/**
 * 负责人类
 * 负责管理备忘录对象
 */
public class CareTaker {
    private EmpMemento empMemento;

    /**
     * 通过容器备忘多次
     * @return
     */
    //private List<EmpMemento> list=new ArrayList<>();

    public EmpMemento getEmpMemento() {
        return empMemento;
    }

    public void setEmpMemento(EmpMemento empMemento) {
        this.empMemento = empMemento;
    }
}
