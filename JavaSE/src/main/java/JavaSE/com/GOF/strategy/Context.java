package JavaSE.com.GOF.strategy;

/**
 * 负责和具体的策略类交互。
 * 使得算法与客户端独立变化。
 * 使用Spring的依赖功能，可以通过配置文件，动态注入不同策略，动态切换不同算法。
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void pringPrice(double s){
        System.out.println("您的报价："+strategy.getprice(s));
    }
}
