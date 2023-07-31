package dzh.com.JavaSE.com.characteristic.interfaces;


abstract class Hand{
    public void show(){
        System.out.println("手技");
    }
}

/**
 * 测试调用优先级
 */
interface Mouth{
    default void show(){
        System.out.println("口技");
    }
}

public class Musician extends Hand implements Mouth{
    public static void main(String[] args) {
        Musician musician = new Musician();
        musician.show();
    }
}
