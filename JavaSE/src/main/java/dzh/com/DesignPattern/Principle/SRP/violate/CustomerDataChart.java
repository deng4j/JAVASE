package dzh.com.DesignPattern.Principle.SRP.violate;

import java.sql.Connection;
import java.util.List;

/**
 * Sunny软件公司开发人员针对某CRM（Customer Relationship Management，客户关系管理）系统中客户信息图形统计模块提出了初始设计方案。
 *
 * CustomerDataChart类承担了太多的职责，既包含与数据库相关的方法，又包含与图表生成和显示相关的方法。
 * 如果在其他类中也需要连接数据库或者使用findCustomers()方法查 询客户信息，则难以实现代码的重用。
 * 无论是修改数据库连接方式还是修改图表显示方式都 需要修改该类，它不止一个引起它变化的原因，
 * 违背了单一职责原则。因此需要对该类进行 拆分，使其满足单一职责原则。
 */
public class CustomerDataChart {
    /**
     * 连接数据库
     */
    public Connection getConnection(){return null;}

    /**
     * 于查询所有的客户信息
     */
    public List findCustomers(){return null;}

    /**
     * 用于创建图表
     */
    public void createChart(){}

    /**
     * 用于显示图表
     */
    public void displayChart(){}
}
