package dzh.com.JavaSE.com.math;

import java.math.BigDecimal;

/**
 * 如果你需要精确的答案，避免使用float和double
 */
public class BigDecimal1 {

    public static void main(String[] args) {

        double a = 1.03;
        double b = a-0.42;
        System.out.println(b);

        BigDecimal funds = new BigDecimal("1.03");
        BigDecimal subtract = funds.subtract(new BigDecimal("0.42"));
        System.out.println(subtract);
    }
}
