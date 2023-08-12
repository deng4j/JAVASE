package dzh.com.DesignPattern.DesignPattern.structuralPatterns.adapter.adapter1.adapter;

/**
 * 相当于USB接口
 *
 * Target（目标抽象类）：目标抽象类定义客户所需接口，可以是一个抽象类或接口，也可以 是具体类。
 */
public interface Target {
    void handleReq();
}
