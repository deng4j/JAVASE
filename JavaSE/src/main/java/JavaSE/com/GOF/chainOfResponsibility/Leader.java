package JavaSE.com.GOF.chainOfResponsibility;

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
     * @param nextLeader
     */
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    /**
     * 处理请求的核心业务方法
     * @param request
     */
    abstract void handleRequest(LeaveRequest request);


}
