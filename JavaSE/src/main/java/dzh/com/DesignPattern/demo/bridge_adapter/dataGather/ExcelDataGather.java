package dzh.com.DesignPattern.demo.bridge_adapter.dataGather;

import dzh.com.DesignPattern.demo.bridge_adapter.api.ExcelAPI;

/**
 * 相当于一个适配器
 */
public class ExcelDataGather extends DataGather{
    private ExcelAPI excelAPI;

    public ExcelDataGather(ExcelAPI excelAPI) {
        this.excelAPI = excelAPI;
    }

    @Override
    public void read() {
        excelAPI.read();
        excelAPI.transfer();
    }
}
