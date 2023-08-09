package dzh.com.DesignPattern.Principle.LSP.violate;

/**
 * 在Sunny软件公司开发的CRM系统中，客户(Customer)可以分为VIP客户(VIPCustomer)和普通 客户(CommonCustomer)两类，系统需要提供一个发送Email的功能，原始设计方案。
 *
 * 在对系统进行进一步分析后发现，无论是普通客户还是VIP客户，发送邮件的过程都是相同 的，也就是说两个send()方法中的代码重复，而且在本系统中还将增加新类型的客户。
 * 为了让系统具有更好的扩展性，同时减少代码重复，使用里氏代换原则对其进行重构。
 */
public class EmailSender {

    public void send(CommonCustomer customer){
        // TODO
    }

    public void send(VIPCustomer customer){
        // TODO
    }
}
