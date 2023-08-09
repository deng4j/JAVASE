package dzh.com.DesignPattern.DesignPattern.strategy;

/**
 * 策略模式：
 * 分离算法，选择实现。
 */
public class App {
    public static void main(String[] args) {
        Strategy s1=new OldCustomerManyStrategy();
        Context context=new Context(s1);
        context.pringPrice(1000);

        Strategy s2 = new NewCustomerFewStrategy();
        context.setStrategy(s2);
        context.pringPrice(1000);
    }
}
