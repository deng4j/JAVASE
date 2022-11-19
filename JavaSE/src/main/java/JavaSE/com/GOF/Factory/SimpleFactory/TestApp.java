package JavaSE.com.GOF.Factory.SimpleFactory;

public class TestApp {
    public static void main(String[] args) {
        try {
            Car beaz = CarFactory.creatCar("benz");
            Car audi = CarFactory.creatCar("Audi");
            beaz.run();
            audi.run();
        } catch (ClassNotFoundException e) {
            System.out.println("没有这个汽车模型");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
