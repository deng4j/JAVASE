package dzh.com.DesignPattern.DesignPattern.transaction;

/**
 * 调用者和发起者
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
