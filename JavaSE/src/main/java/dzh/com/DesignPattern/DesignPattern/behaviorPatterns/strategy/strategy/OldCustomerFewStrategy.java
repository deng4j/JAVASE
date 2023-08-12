package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.strategy.strategy;

/**
 * 老客户小批量
 */

public class OldCustomerFewStrategy implements Strategy {
    @Override
    public double getprice(double standarPrice) {
        System.out.println("打八折");
        return standarPrice*0.85;
    }
}