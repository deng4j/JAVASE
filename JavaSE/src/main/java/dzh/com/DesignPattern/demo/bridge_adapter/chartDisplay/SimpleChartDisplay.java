package dzh.com.DesignPattern.demo.bridge_adapter.chartDisplay;

import dzh.com.DesignPattern.demo.bridge_adapter.dataGather.DataGather;

public class SimpleChartDisplay extends ChartDisplay {

    private DataGather dataGather;

    public SimpleChartDisplay(DataGather dataGather) {
        this.dataGather = dataGather;
    }

    @Override
   public void display() {
        this.dataGather.read();
        System.out.println("简单报表显示");
    }
}
