package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.chainOfResponsibility;

/**
 * Handler（抽象处理者）：它定义了一个处理请求的接口，一般设计为抽象类，由于不同的具体处理者处理请求的方式不同，
 * 因此在其中定义了抽象请求处理方法。因为每一个处理者 的下家还是一个处理者，因此在抽象处理者中定义了一个抽象处理者类型的对象。
 */
public abstract class Leader {
    protected String name;
    /**
     * 责任链上的后继对象
     */
    protected Leader nextLeader;

    public Leader(String name) {
        this.name = name;
    }

    /**
     * 设定责任链上的后继对象
     */
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    /**
     * 处理请求的核心业务方法
     */
    public abstract void handleRequest(LeaveRequest request);


}
