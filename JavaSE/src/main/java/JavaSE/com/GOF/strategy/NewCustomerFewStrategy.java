package JavaSE.com.GOF.strategy;

/**
 * 算法族：
 * 普通客户小批量
 */
public class NewCustomerFewStrategy implements Strategy {
    @Override
    public double getprice(double standarPrice) {
        System.out.println("不打折");
        return standarPrice;
    }
}

/**
 * 普通客户大批量
 */

 class NewCustomerManyStrategy implements Strategy {
    @Override
    public double getprice(double standarPrice) {
        System.out.println("打九折");
        return standarPrice*0.9;
    }
}

/**
 * 老客户小批量
 */

 class OldCustomerFewStrategy implements Strategy {
    @Override
    public double getprice(double standarPrice) {
        System.out.println("打八折");
        return standarPrice*0.85;
    }
}

/**
 * 老客户大批量
 */

 class OldCustomerManyStrategy implements Strategy {
    @Override
    public double getprice(double standarPrice) {
        System.out.println("打七折");
        return standarPrice*0.7;
    }
}


