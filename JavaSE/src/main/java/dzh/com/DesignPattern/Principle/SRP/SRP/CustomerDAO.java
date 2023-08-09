package dzh.com.DesignPattern.Principle.SRP.SRP;

import java.util.List;

/**
 * CustomerDAO：负责操作数据库中的Customer表，包含对Customer表的增删改查等方法
 */
public class CustomerDAO {
    private DBUtil util;

    /**
     * 查询所有的客户信息
     */
    public List findCustomers() {
        // TODO util do something
        return null;
    }
}
