package dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adapter1.adaptee;

/**
 * ps/2接口的键盘
 */
public class KeyBoard implements Adaptee{

    @Override
    public void request(){
        System.out.println("键盘请求");
    }
}
