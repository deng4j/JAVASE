package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.command;

/**
 *  ConcreteCommand（具体命令类）：具体命令类是抽象命令类的子类，实现了在抽象命令类中声明的方法，它对应具体的接收者对象，将接收者对象的动作绑定其中。
 *  在实现execute()方法时，将调用接收者对象的相关操作(Action)。
 */
public class ConcreteCommend implements Commend{
    /**
     * 命令的真正执行者
     */
    private  Receiver receiver;

    public ConcreteCommend(Receiver receiver) {
        this.receiver = receiver;
    }



    @Override
    public void execute() {
        //命令执行前处理
        receiver.action();
        //命令执行后处理
    }
}