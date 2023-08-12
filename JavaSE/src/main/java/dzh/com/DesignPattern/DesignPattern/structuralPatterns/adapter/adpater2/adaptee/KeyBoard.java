package dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adpater2.adaptee;

public class KeyBoard implements Adaptee {

    @Override
    public void request(){
        System.out.println("键盘");
    }
}
