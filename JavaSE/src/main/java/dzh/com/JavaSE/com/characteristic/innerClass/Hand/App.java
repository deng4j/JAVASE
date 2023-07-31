package dzh.com.JavaSE.com.characteristic.innerClass.Hand;

public class App {
    public static void main(String[] args) {
        People people = new People();
        people.getCell();
        Hand.RedCell redCell = new Hand.RedCell(); // 似乎可以直接访问到接口的内部类
    }
}
