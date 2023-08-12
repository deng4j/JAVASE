package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.command;

/**
 * Invoker（调用者）：调用者即请求发送者，它通过命令对象来执行请求。一个调用者并不需要在设计时确定其接收者，因此它只与抽象命令类之间存在关联关系。
 * 在程序运行时可以将一个具体命令对象注入其中，再调用具体命令对象的execute()方法，从而实现间接调用请求接收者的相关操作。
 */
public class Invoke {
    /**
     * 可以使用List<Commend>批处理命令
     */
    private Commend commend;

    public Invoke(Commend commend) {
        this.commend = commend;
    }

    /**
     * 用于调用命令类的方法
     */
    public void call(){
        commend.execute();
    }
}
