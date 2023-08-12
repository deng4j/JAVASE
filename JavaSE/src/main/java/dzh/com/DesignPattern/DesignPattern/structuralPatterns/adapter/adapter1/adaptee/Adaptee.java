package dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adapter1.adaptee;

/**
 * Adaptee（适配者类）：适配者即被适配的角色，它定义了一个已经存在的接口，这个接口 需要适配，适配者类一般是一个具体类，包含了客户希望使用的业务方法，在某些情况下可 能没有适配者类的源代码
 */
public interface Adaptee {

    public void request();
}
