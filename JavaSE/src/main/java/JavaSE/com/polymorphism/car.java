package JavaSE.com.polymorphism;

public abstract class car {
    public abstract void run();
}

class jd extends car{
    @Override
    public void run() {
        System.out.println("捷达汽车可以跑");
    }
    public void got(){
        System.out.println("goto");
    }
}

class  bm extends car{

    @Override
    public void run() {
        System.out.println("宝马汽车跑");
    }
}

class person{
    public void get(car car){
        car.run();
    }
    public static void main(String[] args) {
        //父类引用指向子类对象==>向上转型，即子类对象给了父类的引用。
        car jd=new jd();
        jd.run();

        car bm=new bm();
        bm.run();

        person person=new person();
        person.get(jd);

    }
}



