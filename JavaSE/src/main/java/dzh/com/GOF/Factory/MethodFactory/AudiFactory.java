package dzh.com.GOF.Factory.MethodFactory;

public class AudiFactory implements CarFactory{
    @Override
    public Car creatCar() {
        return new Audi();
    }
}
