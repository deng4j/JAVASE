package dzh.com.DesignPattern.demo.bridge_adapter.api;

public class SimpleExcelApi implements ExcelAPI{
    @Override
    public void read() {
        System.out.println("简单excel读取");
    }

    @Override
    public void transfer() {
        System.out.println("简单excel数据转换");
    }
}
