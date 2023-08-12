package dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adapter1.adapter;

import dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adapter1.adaptee.Adaptee;

/**
 * （USB和ps/2）适配器
 *
 *  Adapter（适配器类）：适配器可以调用另一个接口，作为一个转换器，对Adaptee和Target进 行适配，适配器类是适配器模式的核心，在对象适配器中，它通过继承Target并关联一个 Adaptee对象使二者产生联系。
 */
public class Adapter  implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void setAdaptee(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleReq() {
        adaptee.request();
    }
}
