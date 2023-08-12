package dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adpater2;

import dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adpater2.adaptee.Adaptee;

/**
 * 双向适配器
 */
public class Adapter  implements Target,Adaptee {
    private Adaptee adaptee;
    private Target target;

    public Adapter(Adaptee adaptee,Target target) {
        this.adaptee = adaptee;
        this.target = target;
    }

    @Override
    public void handleReq() {
        adaptee.request();
    }

    @Override
    public void request() {
        target.handleReq();
    }
}