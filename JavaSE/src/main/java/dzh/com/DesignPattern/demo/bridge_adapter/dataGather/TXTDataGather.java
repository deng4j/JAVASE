package dzh.com.DesignPattern.demo.bridge_adapter.dataGather;

public class TXTDataGather extends DataGather{
    @Override
    public void read() {
        System.out.println("txt文本数据读取");
    }
}
