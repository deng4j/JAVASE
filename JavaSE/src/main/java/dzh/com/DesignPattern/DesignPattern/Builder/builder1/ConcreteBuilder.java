package dzh.com.DesignPattern.DesignPattern.Builder.builder1;

/**
 * ConcreteBuilder（具体建造者）：它实现了Builder接口，实现各个部件的具体构造和装配方 法，定义并明确它所创建的复杂对象，也可以提供一个方法返回创建好的复杂产品对象。
 */
public class ConcreteBuilder extends Builder{
    @Override
    public void buildPartA() {
        this.product.setPartA("PA");
    }

    @Override
    public void buildPartB() {
        this.product.setPartB("PB");
    }

    @Override
    public void buildPartC() {
        this.product.setPartC("PC");
    }
}
