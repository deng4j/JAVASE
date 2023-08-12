package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.strategy.strategy;

/**
 * 老客户大批量
 */
public class OldCustomerManyStrategy implements Strategy {
    @Override
    public double getprice(double standarPrice) {
        System.out.println("打七折");
        return standarPrice*0.7;
    }
}