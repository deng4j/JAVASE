package dzh.com.JavaSE.com.characteristic.oop.phone;

public class App {

    public static void main(String[] args) {
        Phone phone=new Phone("康佳",15878);
        phone.usephone("诺基亚","555");
        Phone phone1=phone;
        phone1.usephone("8848","10000");
        phone.sendMsg();
        Phone phone2=new Phone("小米",1356);
        String name = phone2.getName();
        System.out.println(name);
    }
}
