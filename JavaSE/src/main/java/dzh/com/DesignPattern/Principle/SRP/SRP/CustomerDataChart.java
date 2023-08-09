package dzh.com.DesignPattern.Principle.SRP.SRP;


/**
 * 单一职责原则，每个类只做单一的事情。
 *
 * CustomerDataChart：负责图表的生成和显示等
 */
public class CustomerDataChart {

    private CustomerDAO dao;

    /**
     * 用于创建图表
     */
    public void createChart() {
        // TODO dao do something
    }

    /**
     * 用于显示图表
     */
    public void displayChart() {
        // TODO dao do something
    }
}
