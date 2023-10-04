package dzh.com.JavaSE.com.Thread.volatile_.volatile1;

public class Money {
    //强制线程查看共享数据，仅解决数据可见性，不能解决原子性
    public volatile static int money=10000;
    //也可以加同步锁，但会降低效率
    public static void main(String[] args) {
        Boy boy=new Boy();
        Girl girl=new Girl();
        new Thread(boy).start();
        new Thread(girl).start();
    }
}
