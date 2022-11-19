package JavaSE.com.GOF.transaction;

public interface Commend {
    /**
     * 根据需求设计多个不同的方法
     */
    void execute();
}

class ConcreteCommend implements Commend{
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
