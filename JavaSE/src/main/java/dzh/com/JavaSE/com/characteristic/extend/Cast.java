package dzh.com.JavaSE.com.characteristic.extend;

class Animal{
    public void show(){
        System.out.println("animal");
    }
}

class Dog extends Animal{
    public void show(){
        System.out.println("Dog");
    }
}

public class Cast {
    public static void main(String[] args) {
        Dog dog = new Dog();
        // 真实子类可以转成父类
        Animal animal = (Animal) dog;
        animal.show();

        // 真实父类对象不能转子类对象
        // 父类引用指向真实子类对象，可以强转为子类，因为它原本就是子类对象
        Animal a = new Dog();
        Dog d = (Dog) a;
        d.show();
    }
}
