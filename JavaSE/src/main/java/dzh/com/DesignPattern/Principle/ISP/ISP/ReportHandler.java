package dzh.com.DesignPattern.Principle.ISP.ISP;

public interface ReportHandler {
    /**
     * 用于创建图表
     */
    public void createChart();

    /**
     * 用于显示图表
     */
    public void displayChart();
}
