package JavaSE.com.GOF.proxy.dynamicProxy;

/**
 * 真实明星
 */
public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("RealStar");
    }

    @Override
    public void signContract() {
        System.out.println("RealStar.signContract()");
    }

    @Override
    public void bookTicket() {
        System.out.println("RealStar.bookTicket()");
    }

    @Override
    public void sing() {
        System.out.println("周杰伦本人唱歌");
    }

    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney()");
    }
}
