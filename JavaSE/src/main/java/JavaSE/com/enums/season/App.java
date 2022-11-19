package JavaSE.com.enums.season;

public class App {
    public static void main(String[] args) {
        m1();

        m2();
    }

    private static void m2() {
        Car audi1 = Car.AUDI;
        Car audi2 = audi1.getAudi();
        System.out.println(audi1==audi2);

        audi1.run();
        String name = audi1.getName();
        System.out.println(name);
    }

    private static void m1() {
        //返回枚举的名字
        System.out.println(Season.SPRING.name());
        //返回枚举项在枚举类中的索引
        System.out.println(Season.SPRING.ordinal());
        //compareTo比较两个枚举项的索引差值
        System.out.println(Season.SPRING.compareTo(Season.WINTER));
        //返回枚举常量的名称
        System.out.println(Season.SPRING.toString());
        //获取指定枚举类中的指定名称的枚举值
        Season spring = Enum.valueOf(Season.class, "SPRING");
        //返回一个枚举数组
        Season[] values = Season.values();
    }
}
