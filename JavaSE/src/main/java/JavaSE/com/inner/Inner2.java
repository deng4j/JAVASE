package JavaSE.com.inner;

/**
 * 接口中定义一个成员内部类的意义何在？？？
 */
public interface Inner2 {

    String carName="姥爷";

    public default Car  getCar(){
        Car car = new Car();
        return car;
    }

    class Car{
        private String name="宝马";
        private Double price=666.66;

        public void setName(){
            this.name=carName;
        }
    }

}

class Audi implements Inner2{

    public static void main(String[] args) {
        Audi audi = new Audi();
        Car car = new Car();
    }
}
