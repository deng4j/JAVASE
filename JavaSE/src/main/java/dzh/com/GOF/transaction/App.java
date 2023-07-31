package dzh.com.GOF.transaction;

/**
 * 命令模式（事务模式）：
 * 应用场景：数据库事务机制。
 */
public class App {
    public static void main(String[] args) {
        Commend c=new ConcreteCommend(new Receiver());

        Invoke invoke=new Invoke(c);
        invoke.call();
    }
}
