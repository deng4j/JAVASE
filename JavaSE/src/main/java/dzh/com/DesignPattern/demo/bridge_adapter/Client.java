package dzh.com.DesignPattern.demo.bridge_adapter;

import dzh.com.DesignPattern.demo.bridge_adapter.api.SimpleExcelApi;
import dzh.com.DesignPattern.demo.bridge_adapter.chartDisplay.SimpleChartDisplay;
import dzh.com.DesignPattern.demo.bridge_adapter.dataGather.ExcelDataGather;

public class Client {
    public static void main(String[] args) {
        ExcelDataGather excelDataGather = new ExcelDataGather(new SimpleExcelApi());
        SimpleChartDisplay simpleChartDisplay = new SimpleChartDisplay(excelDataGather);
        simpleChartDisplay.display();
    }
}
