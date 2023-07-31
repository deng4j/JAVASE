package dzh.com.JavaSE.com.characteristic.oop.phone;

import java.util.Scanner;

/**
 * 面向对象，将世间万物都看作一个对象，有自己的属性、功能
 */
public class Phone {
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

    public Phone() {
    }

    public Phone(String name, Object price) {
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
