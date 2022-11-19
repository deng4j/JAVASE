package JavaSE.com.oop.phone;

import java.util.Scanner;

public class phone {
    private  String name;
    private  Object price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    public phone() {
    }

    public phone(String name, Object price) {
        this.name = name;
        this.price = price;
    }

    public  void  usephone(String name, Object price){
        this.name=name;
        this.price=price;
    }

    public void sendMsg(){
        System.out.println("["+name+"---"+price+"]"+this);
         Msg();

    }
    public void Msg( ){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入发送人");
        String name=scanner.next();
        System.out.println("请输入信息");
        String msg=scanner.next();
        System.out.println(name+":"+msg);

    }

}
