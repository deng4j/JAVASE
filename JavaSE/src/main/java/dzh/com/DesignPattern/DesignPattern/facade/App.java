package dzh.com.DesignPattern.DesignPattern.facade;

/**
 * 外观模式：
 * 客户通过注册门面进行注册公司，避免自己亲力亲为。
 * 迪米特法则：避免和多个对象产生关系。
 *
 */
public class App {
    public static void main(String[] args) {
        new RegisterFacade().register();
    }
}
