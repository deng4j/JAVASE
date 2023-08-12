package dzh.com.DesignPattern.Principle.CRP.violate;

import java.sql.Connection;

/**
 * Sunny软件公司开发人员在初期的CRM系统设计中，考虑到客户数量不多，系统采用MySQL 作为数据库，与数据库操作有关的类如CustomerDAO类等都需要连接数据库，
 * 连接数据库的 方法getConnection()封装在DBUtil类中，由于需要重用DBUtil类的getConnection()方法，设计人 员将CustomerDAO作为DBUtil类的子类，初始设计方案。
 *
 * 随着客户数量的增加，系统决定升级为Oracle数据库，因此需要增加一个新的OracleDBUtil类来连接Oracle数据库，
 * 由于在初始设计方案中CustomerDAO和DBUtil之间是继承关系，因此在更换数据库连接方式时需要修改CustomerDAO类的源代码，
 * 将CustomerDAO作为OracleDBUtil的子类，这将违反开闭原则。【当然也可以修改DBUtil类的源代码，同样会违反开闭原则。】
 */
public class CustomerDAO extends DBUtil {

    public void addCustomer(){
        // TODO ...
        Connection connection = super.getConnection();
        // TODO ...
    }
}
