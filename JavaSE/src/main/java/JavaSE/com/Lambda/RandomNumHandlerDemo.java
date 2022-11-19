package JavaSE.com.Lambda;

interface RandomNumHandler {

    double getNumber();
}

public class RandomNumHandlerDemo {

    public static void main(String[] args) {
        //请分别使用匿名内部类 和 lambda表达式作为参数进行调用
        //要求每次调用useRandomNumHandler方法的时候, 都随机产生一个随机数
        useRandomNumHandler(new RandomNumHandler() {
            @Override
            public double getNumber() {

                return Math.random() * 10;
            }
        });

        RandomNumHandler r = () -> Math.random() * 10;
        useRandomNumHandler(r);
    }

    public static void useRandomNumHandler(RandomNumHandler rh) {

        double result = rh.getNumber();
        System.out.println(result);
    }
}
