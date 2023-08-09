package dzh.com.DesignPattern.Principle.OCP.violate;

/**
 * Sunny软件公司开发的CRM系统可以显示各种类型的图表，如饼状图和柱状图等，为了支持多 种图表显示方式，原始设计方案
 *
 * 在该代码中，如果需要增加一个新的图表类，如折线图LineChart，则需要修改ChartDisplay类 的display()方法的源代码，增加新的判断逻辑，违反了开闭原则。
 */
public class ChartDisplay {

    public void display(String type) {
        if (type.equals("pie")) {
            PieChart chart = new PieChart();
            chart.display();
        } else if (type.equals("bar")) {
            BarChart chart = new BarChart();
            chart.display();
        }
        // ... ...
    }
}
