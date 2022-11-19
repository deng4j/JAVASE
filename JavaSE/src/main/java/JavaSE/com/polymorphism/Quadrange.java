package JavaSE.com.polymorphism;

/**
 * 接口的多态
 */
interface quad{
    int a=10;
    void draw();
}

public class Quadrange {
    public   void dothoer(){
        System.out.println("四边形");
    }
}

class Paralle extends Quadrange implements quad{

    @Override
    public void draw() {
        System.out.println("平行四边形");
    }

    @Override
    public void dothoer() {
        System.out.println("平行");
    }
}

class  Square extends Quadrange implements quad{

    @Override
    public void draw() {
        System.out.println("正方形");
    }

    @Override
    public void dothoer() {
        System.out.println("正方");
    }
}

//--------------------------------------------------

class test{
    public static void Do(Quadrange q){
        q.dothoer();
    }

    public static void main(String[] args) {
        quad p=new Paralle();//向上转型为接口
        p.draw();
        quad s=new Square();
        s.draw();
        System.out.println("-------------");
        Quadrange qp=new Paralle();//父类的多态
        Do(qp);
    }
}
