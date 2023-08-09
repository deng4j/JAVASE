package dzh.com.JavaSE.com.characteristic.polymorphism;

/**
 * 构造器内部的多态行为
 */
public class constructorpolymorphism {
    public static void main(String[] args) {
        new RoundGlph(5);
    }
}

class Glph{
    void draw(){
        System.out.println("Glph.draw()");
    }

    public Glph() {
        System.out.println("Glph before draw()");
        draw();
        System.out.println("Glph after draw()");
    }
}

class RoundGlph extends  Glph{
    private  int radius=1;
    RoundGlph(int r){
        //隐含了一个super();
        radius=r;
        System.out.println("RoundGlph.draw(), radius="+radius);
    }

    @Override
    void draw() {
        System.out.println("RoundGlph.draw(), radius="+radius);
    }
}