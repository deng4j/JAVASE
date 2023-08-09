package dzh.com.DesignPattern.Principle.ISP.ISP;

public interface ChartHandler {

    /**
     * 用于创建文字报表
     */
    public void createReport();

    /**
     * 用于显示文字报表
     */
    public void displayReport();
}
