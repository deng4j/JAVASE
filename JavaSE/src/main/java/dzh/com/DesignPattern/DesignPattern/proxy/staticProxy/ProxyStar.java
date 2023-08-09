package dzh.com.DesignPattern.DesignPattern.proxy.staticProxy;

/**
 * 代理人什么都可以做，就是不能唱歌，所有需要调歌手的方法
 */
public class ProxyStar implements Star {
    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("Proxy.confer()");
    }

    @Override
    public void signContract() {
        System.out.println("Proxy.signContract()");
    }

    @Override
    public void bookTicket() {
        System.out.println("Proxy.bookTicket()");
    }

    @Override
    public void sing() {
        star.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("Proxy.collectMoney()");
    }
}
