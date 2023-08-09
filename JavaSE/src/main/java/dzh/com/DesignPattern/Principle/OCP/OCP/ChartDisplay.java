package dzh.com.DesignPattern.Principle.OCP.OCP;

/**
 * 1.增加一个抽象图表类AbstractChart，将各种具体图表类作为其子类；
 * 2.ChartDisplay类针对抽象图表类进行编程，由客户端来决定使用哪种具体图表。
 */
public class ChartDisplay {
    private AbstractChart chart;

    /**
     * 由客户端来设置实例化的具体图表对象
     */
    public void setChart(AbstractChart chart){
        this.chart = chart;
    }

    /**
     * 由客户端来显示具体那种表
     */
    public void display(){
        chart.display();
    }
}
