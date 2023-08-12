package dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adapter1.adaptee;

/**
 * ps/2接口的鼠标
 */
public class Mouse implements Adaptee{
    @Override
    public void request() {
        System.out.println("鼠标请求");
    }
}
