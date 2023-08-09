package dzh.com.DesignPattern.DesignPattern.mediator;

/**
 * 中介接口
 */
public interface Mediator {
    void register(String dname,Department department);
    void commend(String dname);
}
