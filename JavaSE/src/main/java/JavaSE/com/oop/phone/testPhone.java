package JavaSE.com.oop.phone;

public class testPhone {

    public static void main(String[] args) {
        phone phone=new phone("康佳",15878);
        phone.usephone("诺基亚","555");
        phone phone1=phone;
        phone1.usephone("8848","10000");
        phone.sendMsg();
        phone phone2=new phone("小米",1356);
        String name = phone2.getName();
        System.out.println(name);


    }
}
