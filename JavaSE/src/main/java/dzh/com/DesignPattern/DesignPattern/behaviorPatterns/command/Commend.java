package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.command;

/**
 * Command（抽象命令类）：抽象命令类一般是一个抽象类或接口，在其中声明了用于执行请求的execute()等方法，通过这些方法可以调用请求接收者的相关操作。
 */
public interface Commend {
    /**
     * 根据需求设计多个不同的方法
     */
    void execute();
}
