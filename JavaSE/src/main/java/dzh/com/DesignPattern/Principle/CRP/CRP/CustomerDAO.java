package dzh.com.DesignPattern.Principle.CRP.CRP;

import java.sql.Connection;

/**
 * CustomerDAO和DBUtil之间的关系由继承关系变为关联关系，采用依赖注入的方式 将DBUtil对象注入到CustomerDAO中，
 * 可以使用构造注入，也可以使用Setter注入。如果需要 对DBUtil的功能进行扩展，可以通过其子类来实现，
 * 如通过子类OracleDBUtil来连接Oracle数 据库。由于CustomerDAO针对DBUtil编程，根据里氏代换原则，
 * DBUtil子类的对象可以覆盖 DBUtil对象，只需在CustomerDAO中注入子类对象即可使用子类所扩展的方法。
 * 例如在 CustomerDAO中注入OracleDBUtil对象，即可实现Oracle数据库连接，原有代码无须进行修改，而且还可以很灵活地增加新的数据库连接方式。
 */
public class CustomerDAO {
    private DBUtil util;

    public void addCustomer(){
        // TODO ...
        Connection connection = util.getConnection();
        // TODO ...
    }
}
