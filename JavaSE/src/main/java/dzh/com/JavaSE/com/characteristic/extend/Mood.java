package dzh.com.JavaSE.com.characteristic.extend;

/**
 * @Thinking in java 4
 * 用继承表示行为之间的差异，用字段表达状态的差异
 */
public class Mood {
    public static void main(String[] args) {
        Storage s=new Storage();
        s.change();
        s.show();
    }
}

class Actor{
    public void act(){}
}
class Happy extends Actor{
    @Override
    public void act() {
        System.out.println("Happy");
    }
}
class Sad extends Actor{
    @Override
    public void act() {
        System.out.println("Sad");
    }
}
class Storage{
    private Actor a=new Happy();
    public void change(){
        a=new Sad();
    }
    public  void show(){
        a.act();
    }
}
