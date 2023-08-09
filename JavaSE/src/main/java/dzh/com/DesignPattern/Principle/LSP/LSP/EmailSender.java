package dzh.com.DesignPattern.Principle.LSP.LSP;

/**
 * 里氏代换原则是实现开闭原则的重要方式之一。
 * 在本实例中，在传递参数时使用基类对象， 除此以外，在定义成员变量、定义局部变量、确定方法返回类型时都可使用里氏代换原则。针对基类编程，在程序运行时再确定具体子类。
 */
public class EmailSender {

    public void send(Customer customer){
        // TODO customer doing something
    }
}
