package dzh.com.DesignPattern.DesignPattern.createPatterns.Builder.builder1;

/**
 * Director（指挥者）：指挥者又称为导演类，它负责安排复杂对象的建造次序，指挥者与抽 象建造者之间存在关联关系，
 * 可以在其construct()建造方法中调用建造者对象的部件构造与装 配方法，完成复杂对象的建造。客户端一般只需要与指挥者进行交互，
 * 在客户端确定具体建 造者的类型，并实例化具体建造者对象（也可以通过配置文件和反射机制），然后通过指挥 者类的构造函数或者Setter方法将该对象传入指挥者类中。
 */
class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    //产品构建与组装方法
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}