package dzh.com.DesignPattern.Principle.DIP.DIP;

import java.lang.reflect.Constructor;

/**
 * 引入抽象数据转换类DataConvertor之后，CustomerDAO针对抽象类 DataConvertor编程，而将具体数据转换类名存储在配置文件中，符合依赖倒转原则。
 * 根据里 氏代换原则，程序运行时，具体数据转换类对象将替换DataConvertor类型的对象，程序不会 出现任何问题。更换具体数据转换类时无须修改源代码，
 * 只需要修改配置文件；如果需要增 加新的具体数据转换类，只要将新增数据转换类作为DataConvertor的子类并修改配置文件即 可，原有代码无须做任何修改，满足开闭原则。
 */
public class CustomerDAO {

    public void addCustomers() throws Exception {
        // TODO get config.xml className
        Class<?> txtDataConvertor = Class.forName("TXTDataConvertor");
        Constructor<?> constructor = txtDataConvertor.getConstructor();

        DataConvertor dataConvertor = (DataConvertor) constructor.newInstance();
        dataConvertor.readFile();
    }
}
