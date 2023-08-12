package dzh.com.DesignPattern.DesignPattern.structuralPatterns.proxy.dynamicProxy.JDK;

/**
 * 真实明星
 */
public class RealStar implements Star {
    @Override
    public void sing() {
        System.out.println("周杰伦唱歌");
    }
}
