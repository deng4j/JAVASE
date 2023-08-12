package dzh.com.DesignPattern.demo.bridge_adapter.chartDisplay;

import dzh.com.DesignPattern.demo.bridge_adapter.dataGather.DataGather;

public class ComplexChartDisplay extends ChartDisplay {

    private DataGather dataGather;

    public ComplexChartDisplay(DataGather dataGather) {
        this.dataGather = dataGather;
    }

    @Override
    public void display() {
        this.dataGather.read();
        System.out.println("复杂报表显示");
    }
}
