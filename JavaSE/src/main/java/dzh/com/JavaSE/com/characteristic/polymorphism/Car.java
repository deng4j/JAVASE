package dzh.com.JavaSE.com.characteristic.polymorphism;

/**
 * 多态就是同一个接口，使用不同的实例而执行不同操作。（一个引用，多个实例）
 * 多态存在的三个必要条件：
 *  1.继承/实现
 *  2.重写
 *  3.父类引用指向子类对象
 */
public abstract class Car {
    public abstract void run();
}

class Jd extends Car{
    @Override
    public void run() {
        System.out.println("捷达汽车可以跑");
    }
}

class  Bm extends Car{
    @Override
    public void run() {
        System.out.println("宝马汽车跑");
    }

    public void airConditioning(){
        System.out.println("宝马，开空调");
    }
}

class person{
    public void drive(Car car){
        car.run();
        if (car instanceof Bm){ // 判断是否是宝马车，防止强转异常
            Bm bm = (Bm) car; // 强转成宝马车，因为对象本质是宝马车。向下转型
            bm.airConditioning();
        }
    }

    public static void main(String[] args) {
        //父类引用指向子类对象，向上转型，即子类对象给了父类的引用。
        Car jd=new Jd();
        jd.run();

        System.out.println("---------------------------");

        Bm bm=new Bm();
        bm.run();

        System.out.println("---------------------------");

        person person=new person();
        person.drive(jd);

        System.out.println("---------------------------");

        person.drive(bm);
    }
}



