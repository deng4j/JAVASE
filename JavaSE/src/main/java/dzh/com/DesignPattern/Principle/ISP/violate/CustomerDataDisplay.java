package dzh.com.DesignPattern.Principle.ISP.violate;

/**
 * Sunny软件公司开发人员针对某CRM系统的客户数据显示模块设计了接口。
 *
 * 在实际使用过程中发现该接口很不灵活，例如如果一个具体的数据显示类无须进行数据转换 （源文件本身就是XML格式），
 * 但由于实现了该接口，将不得不实现其中声明的transformToXML()方法（至少需要提供一个空实现）；
 * 如果需要创建和显示图表，除了需实现 与图表相关的方法外，还需要实现创建和显示文字报表的方法，否则程序编译时将报错。
 */
public interface CustomerDataDisplay {

    /**
     * 用于从文件中读取数据
     */
    public void dataRead();

    /**
     * 用于将数据转换成XML格式
     */
    public void transformToXML();

    /**
     * 用于创建图表
     */
    public void createChart();

    /**
     * 用于显示图表
     */
    public void displayChart();

    /**
     * 用于创建文字报表
     */
    public void createReport();

    /**
     * 用于显示文字报表
     */
    public void displayReport();
}
