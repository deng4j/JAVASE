package dzh.com.DesignPattern.DesignPattern.structuralPatterns.decorator.decorator1;

/**
 * 装饰模式(Decorator Pattern)：动态地给一个对象增加一些额外的职责，就增加对象功能来说， 装饰模式比生成子类实现更为灵活。装饰模式是一种对象结构型模式。
 *
 * 装饰模式是一种用于替代继承的技术，它通过一种无须定义子类的方式来给对象动态增加职 责，使用对象之间的关联关系取代类之间的继承关系。
 * 在装饰模式中引入了装饰类，在装饰 类中既可以调用待装饰的原有类的方法，还可以增加新的方法，以扩充原有类的功能。
 *
 * 由于具体构件类和装饰类都实现了相同的抽象构件接口，因此装饰模式以对客户透明的方式动态地给一个对象附加上更多的责任，
 * 换言之，客户端并不会觉得对象在装饰前和装饰后有 什么不同。装饰模式可以在不需要创造更多子类的情况下，将对象的功能加以扩展。
 *
 * 在实际使用过程中，由于新增行为可能需要单独调用，因此这种形式的装饰模式也经常出 现，这种装饰模式被称为半透明(Semi-transparent)装饰模式，而标准的装饰模式是透明 (Transparent)装饰模式。
 *
 * 主要优点：
 *  1.对于扩展一个对象的功能，装饰模式比继承更加灵活性，不会导致类的个数急剧增加。
 *  2.可以通过一种动态的方式来扩展一个对象的功能，通过配置文件可以在运行时选择不同的 具体装饰类，从而实现不同的行为。
 *  3.可以对一个对象进行多次装饰，通过使用不同的具体装饰类以及这些装饰类的排列组合， 可以创造出很多不同行为的组合，得到功能更为强大的对象。
 *  4.具体构件类与具体装饰类可以独立变化，用户可以根据需要增加新的具体构件类和具体装 饰类，原有类库代码无须改变，符合“开闭原则”。
 *
 * 主要缺点:
 *  1.使用装饰模式进行系统设计时将产生很多小对象，这些对象的区别在于它们之间相互连接 的方式有所不同，而不是它们的类或者属性值有所不同，大量小对象的产生势必会占用更多 的系统资源，在一定程序上影响程序的性能。
 *  2.装饰模式提供了一种比继承更加灵活机动的解决方案，但同时也意味着比继承更加易于出 错，排错也很困难，对于多次装饰的对象，调试时寻找错误可能需要逐级排查，较为繁琐。
 *
 * 适用场景:
 *  1.在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
 *  2.当不能采用继承的方式对系统进行扩展或者采用继承不利于系统扩展和维护时可以使用装 饰模式。
 *    不能采用继承的情况主要有两类：
 *      第一类是系统中存在大量独立的扩展，为支持每 一种扩展或者扩展之间的组合将产生大量的子类，使得子类数目呈爆炸性增长；
 *      第二类是因 为类已定义为不能被继承（如Java语言中的final类）。
 */
public class Client {
    public static void main(String[] args) {
        semiTransparent();
    }

    /**
     * 透明装饰模式的设计难度较大，而且有时我们需要单独调用新增的业务方法。
     * 为了能够调用到新增方法，我们不得不用具体装饰类型来定义装饰之后的对象，而具体构件类型还是可以使用抽象构件类型来定义，
     * 这种装饰模式即为半透明装饰模式，也就是说，对于客户端而言，具体构件类型无须关心，是透明的；但是具体装饰类型必须指定，这是不透明的。
     *
     * 半透明装饰模式可以给系统带来更多的灵活性，设计相对简单，使用起来也非常方便；但是 其最大的缺点在于不能实现对同一个对象的多次装饰，
     * 而且客户端需要有区别地对待装饰之 前的对象和装饰之后的对象。
     */
    private static void semiTransparent() {
        Component concreteComponent = new ConcreteComponent(); //使用抽象构件类型定义
        ConcreteDecorator concreteDecorator = new ConcreteDecorator(concreteComponent); //使用具体装饰类型定义
        concreteDecorator.operation();
    }

    /**
     * 在透明装饰模式中，要求客户端完全针对抽象编程，装饰模式的透明性要求客户端程序不应 该将对象声明为具体构件类型或具体装饰类型，而应该全部声明为抽象构件类型。
     *
     * 透明装饰模式可以让客户端透明地使用装饰之前的对象和装饰之后的对象，无须关心它们的 区别，此外，还可以对一个已装饰过的对象进行多次装饰，得到更为复杂、功能更为强大的对象。
     */
    private static void Transparent() {
        // 使用抽象构件类型定义对象
        Component concreteComponent = new ConcreteComponent();
        Component concreteDecorator =new ConcreteDecorator(concreteComponent);

        concreteDecorator.operation();
    }
}
