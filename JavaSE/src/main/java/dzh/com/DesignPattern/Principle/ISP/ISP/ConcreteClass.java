package dzh.com.DesignPattern.Principle.ISP.ISP;

/**
 * 口按照接口隔离原则和单一职责 原则进行重构，将其中的一些方法封装在不同的小接口中，确保每一个接口使用起来都较为方便，
 * 并都承担某一单一角色，每个接口中只包含一个客户端（如模块或类）所需的方法即可。
 */
public class ConcreteClass implements DataHandler,ChartHandler{
    @Override
    public void createReport() {

    }

    @Override
    public void displayReport() {

    }

    @Override
    public void dataRead() {

    }
}
