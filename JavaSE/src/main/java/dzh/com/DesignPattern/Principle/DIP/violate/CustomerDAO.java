package dzh.com.DesignPattern.Principle.DIP.violate;

/**
 * Sunny软件公司开发人员在开发某CRM系统时发现：该系统经常需要将存储在TXT或Excel文 件中的客户信息转存到数据库中，
 * 因此需要进行数据格式转换。在客户数据操作类中将调用数据格式转换类的方法实现格式转换和数据库插入操作，初始设计方案
 *
 * Sunny软件公司开发人员发现该设计方案存在一个非常严重的问 题，由于每次转换数据时数据来源不一定相同，因此需要更换数据转换类，
 * 如有时候需要将 TXTDataConvertor改为ExcelDataConvertor，此时，需要修改CustomerDAO的源代码，
 * 而且在 引入并使用新的数据转换类时也不得不修改CustomerDAO的源代码，系统扩展性较差，违反 了开闭原则，现需要对该方案进行重构。
 *
 * CustomerDAO针对 具体数据转换类 编程
 */
public class CustomerDAO {

    /**
     * 针对具体数据转换类编程
     */
    public void addCustomers(){
        TXTDataConvertor txtDataConvertor = new TXTDataConvertor();
        txtDataConvertor.readFile();
        // TODO txtDataConvertor
    }
}
