package dzh.com.DesignPattern.DesignPattern.bridge.Usebridge;

/**
 * 桥接模式（使用组合代替继承）：
 * 处理多层继承结构，处理多维度变化场景，将各个维度
 * 设计成独立的继承结构，使各个维度可以独立的拓展在抽象层建立联系。
 */
public class App {
    public static void main(String[] args) {
        Computer dell=new DeskTop(new Dell());
        dell.sale();

        Computer lenovo=new LapTop(new Lenovo());
        lenovo.sale();
    }
}
