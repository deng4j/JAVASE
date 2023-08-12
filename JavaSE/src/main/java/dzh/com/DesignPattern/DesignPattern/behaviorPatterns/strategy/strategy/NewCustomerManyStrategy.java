package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.strategy.strategy;

/**
 * 普通客户大批量
 */

 public class NewCustomerManyStrategy implements Strategy {
    @Override
    public double getprice(double standarPrice) {
        System.out.println("打九折");
        return standarPrice*0.9;
    }
}