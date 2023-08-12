package dzh.com.JavaSE.com.characteristic.interfaces.People;

public class People implements Hand {
    public static void main(String[] args) {
        People p = new People();
        p.defaultWork();

        Hand.absorb();//只能通过接口名调用
        System.out.println(Hand.finger);
    }

    @Override
    public void skin() {
        System.out.println("--yellow skin--");
    }
}